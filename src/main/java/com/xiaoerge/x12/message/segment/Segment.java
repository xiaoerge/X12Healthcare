package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.MessageLoop;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class Segment extends MessageLoop
{
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    private boolean parseError;
    protected int fieldSize;
    protected String name, content;
    
    protected class DataElement {
    	String[] components;
    	
    	public DataElement(int length) {
    		components = new String[length];
    		for (int i=0;i<components.length;i++) {
    			components[i] = "";
    		}
    	}
    	public DataElement(String[] components)
    	{
    		if (this.components==null) this.components = new String[components.length];
    		set(components);
    	}
    	public String get(int idx) {
    		if (idx<0 || idx>=components.length) return "";
    		return components[idx];
    	}
    	public void set(int idx, String s) {
    		if (idx<0 || idx>=components.length) return;
    		components[idx] = s;
    	}
    	public void set(String[] components) {
    		for (int i=0;i<components.length;i++) {
    			this.components[i] = components[i];
    		}
    	}
    	public int size() { return components.length; }
    	// save awkward collection[i].toString().length() call
    	public int length() { return toString().length(); }
    	public String toString() {
    		return StringUtils.join(components, messageFormat.getComponentElementSeparator());
    	}
    }
    protected DataElement[] collection;

    public Segment() {
        this("", new MessageFormat());
    }
    public Segment(String c, MessageFormat mf) {
        parseError = false;
        content = c;
    	this.messageFormat = mf;

        Class obj = this.getClass();
        if (obj.isAnnotationPresent(Declaration.class)) {
            Declaration declaration = (Declaration) obj.getAnnotation(Declaration.class);
            fieldSize = declaration.fieldSize();
            name = declaration.name();
        }


        if (c.length() > 0 && !c.startsWith(name)) {
            logger.error(String.format("Invalid segment constructor %s for message %s", name, c));
        }
        else parse();
    }

    private Definition findDefinition(int position) {
        Class obj = this.getClass();
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Definition.class)) {
                Definition definition = method.getAnnotation(Definition.class);
                if (definition.position()==position) return definition;
            }
        }
        return null;
    }
    private void parse() {
        collection = new DataElement[fieldSize+1];
     	collection[0] = new DataElement(1);
        setField(0,name);
        
        // FIX ME - slow
        for (int i = 1; i < collection.length; i++) {
        	Definition definition = findDefinition(i);
        	if (definition!=null) {
        		collection[i] = new DataElement(definition.maxComponents());
        	} 
        }

        if (content.length() > 0){
        	String c = content.trim();
            if (c.charAt(c.length() - 1) != messageFormat.getSegmentTerminator().charAt(0)) {
                parseError = true;
                logger.info(name+" parse()");
                logger.warn(name+" missing segment terminator", content);
                //collection = content.split(Pattern.quote(dataElementSeparator));
            }
            else {
                String[] pCollection = c.substring(0, c.length()-1).split(Pattern.quote(messageFormat.getDataElementSeparator()));
                int min = Math.min(collection.length, pCollection.length);
                for (int i = 0; i < min; i++) {
                    try {
                        setField(i,pCollection[i]);
                    }
                    catch (Exception ex) {
                        setField(i,"");
                        logger.error(ex.getMessage(), content);
                    }
                }

                if (pCollection.length > collection.length) {
                    parseError = true;
                    logger.info(name+" parse()");
                    logger.warn(name+" field length should be less than or equal to "+fieldSize, content);
                }
            }
        }
    }

    public int size() {
        return fieldSize;
    }
    public void loadDefinition() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean validate()
    {
        boolean validateName = validateName(), validateFieldSize = validateFieldSize(), validateDataLength = validateDataLength();
        if (parseError) logger.warn(name+" parse() validation failed");
        if (!validateName) logger.warn(name+" validateName() validation failed");
        if (!validateFieldSize) logger.warn(name+" validateFieldSize() validation failed");
        if (!validateDataLength) logger.warn(name+" validateDataLength() validation failed");

        return !parseError && validateName && validateFieldSize && validateDataLength;
    }

    private boolean validateName() {
        boolean v = name.length() > 0 && collection[0].toString().equals(name);
        if (!v) {
            logger.info(name+" validateName()");
            logger.warn(name+" Segment field does not match");
        }
        return v;
    }

    private boolean validateFieldSize() {
        boolean v = collection.length-1 <= fieldSize;
        if (!v) {
            logger.info(name+" validateFieldSize()");
            logger.warn(name+" size should be "+fieldSize);
        }
        return v;
    }
    private boolean validateDataLength(String code, Definition definition)
    {
        boolean v =  code.length() >= definition.minLength() && code.length() <= definition.maxLength();
    	if (!v) {
    		logger.warn(name+" validateDataLength()");
    		String message = (definition.minLength() == definition.maxLength()) ?
    		definition.minLength()+"" : "between "+definition.minLength()+", "+definition.maxLength();
            logger.warn(name+""+String.format("%02d", definition.position())+" length should be "+message+" ("+code+")");
            return false;
    	}
    	return true;
    }

    private boolean validateDataLength() {
        boolean ret = true;
        Class obj = this.getClass();
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Definition.class)) {
                Definition definition = method.getAnnotation(Definition.class);

                try {
                    String code = (String) method.invoke(this);
                    if (code.length() == 0) continue;
                    
                    if (code.indexOf(messageFormat.getRepetitionSeparator()) >= 0) 
                    {
                    	String[] codes = code.split(Pattern.quote(messageFormat.getRepetitionSeparator()));
                    	ret = true;
                    	for (String code2 : codes) {
                    		if (!validateDataLength(code2, definition)) ret = false;
                    	}
                    } else {
                   		if (!validateDataLength(code, definition)) ret = false;
                    }
                    
                } catch (IllegalAccessException e) {
                    return false;
                } catch (InvocationTargetException e) {
                    return false;
                }
            }
        }
        return ret;
    }

    @Override
    public String toX12String() {

        if (isEmpty()) return "";
        if (!validate()) return name.concat(StringUtils.repeat("*", fieldSize)).concat(messageFormat.getSegmentTerminator());

        setField(0,name);
        StringBuilder builder = new StringBuilder();
        builder.append(name).append("*");

        int i = collection.length-1, j = i;

        while (i > 0) {
            if (collection[i].length() != 0) {
                j = i;
                break;
            }
            i--;
        }
        for (i = 1; i < j+1; i++) {
            builder.append(collection[i]).append("*");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(messageFormat.getSegmentTerminator());

        return builder.toString();
    }

    @Override
    public boolean isEmpty() {
        boolean ret = true;
        for (int i = 1; i < collection.length; i++) {
            if (collection[i].length() > 0) return false;
        }
        return true;
    }
    
    protected String getField(int idx, int subidx) {
        return collection[idx].get(subidx);
    }
    protected String getField(int idx) {
        return collection[idx].toString();
    }
    protected void setField(int idx, int subidx, String value) {
        collection[idx].set(subidx, value);
    }
    protected void setField(int idx, String value) {
        if (collection[idx].size() > 1 && value.indexOf(messageFormat.getComponentElementSeparator()) >= 0) 
        {
        	// important to pass -1 on split as delimiter only string 
        	// (like ISA16) will result in zero length array otherwise
        	String[] components = value.split(Pattern.quote(messageFormat.getComponentElementSeparator()), -1);
        	collection[idx].set(components);
        } else {
        	collection[idx].set(0, value);
        }
    }
}
