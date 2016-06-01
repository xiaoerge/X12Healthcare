package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;
import com.xiaoerge.healthcare.x12.enumeration.Required;
import com.xiaoerge.healthcare.x12.message.IMessage;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class Segment implements IMessage
{
    static Logger logger = Logger.getLogger(Segment.class.getName());

    private boolean parseError;
    protected int requiredSize, fieldSize;
    protected String name, content, delimiter;
    protected String[] collection;

    public Segment() {
        this("");
    }
    public Segment(String c) {
        parseError = false;
        content = c;
        delimiter = "*";

        Class obj = this.getClass();
        if (obj.isAnnotationPresent(Declaration.class)) {
            Declaration declaration = (Declaration) obj.getAnnotation(Declaration.class);
            requiredSize = declaration.requiredSize();
            fieldSize = declaration.fieldSize();
            name = declaration.name();
        }

        parse();
    }

    private void parse() {
        if (content.length() == 0) {
            collection = new String[requiredSize+1];
            collection[0] = name;
            return;
        }

        if (content.charAt(content.length() - 1) != '~') {
            parseError = true;
            logger.log(Level.SEVERE, name+" missing segment terminator");
            //collection = content.split(Pattern.quote(delimiter));
        }
        else {
            collection = content.substring(0, content.length()-1).split(Pattern.quote(delimiter));
        }
    }

    public int size() {
        return requiredSize;
    }

    public String toX12String() {
        return toString();
    }

    public boolean validate()
    {
        return !parseError
                && validateName() && validateSize() && validateRequired()
                && validateCodeValue() && validateDataLength();
    }

    private boolean validateName() {
        boolean v = name.length() > 0 && collection[0].equals(name);
        if (!v) logger.log(Level.SEVERE, name+" Segment field does not match");
        return v;
    }

    private boolean validateRequired() {
        boolean ret = true;
        Class obj = this.getClass();
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Definition.class)) {
                Definition definition = (Definition) method.getAnnotation(Definition.class);

                if (definition.required() != Required.REQUIRED) continue;
                try {
                    String code = (String) method.invoke(this);
                    boolean v = code != null && code.length() > 0;
                    if (!v) {
                        logger.log(Level.SEVERE, name+""+String.format("%02d", definition.position())+" is required but missing");
                        ret = false;
                    }
                } catch (IllegalAccessException e) {
                    logger.log(Level.SEVERE, e.getMessage());
                    return false;
                } catch (InvocationTargetException e) {
                    logger.log(Level.SEVERE, e.getMessage());
                    return false;
                }
            }
        }
        return ret;
    }

    private boolean validateCodeValue() {
        boolean ret = true;
        Class obj = this.getClass();
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Definition.class)) {
                Definition definition = (Definition) method.getAnnotation(Definition.class);

                if (definition.codeValues().length == 0) continue;
                try {
                    String code = (String) method.invoke(this);
                    boolean v =  ArrayUtils.contains(definition.codeValues(), code);
                    if (!v) {
                        logger.log(Level.SEVERE, name+""+String.format("%02d", definition.position())+" is not a valid. Valid values are "+ArrayUtils.toString(definition.codeValues()));
                        ret = false;
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

    private boolean validateSize() {
        boolean v = requiredSize != 0 && collection.length-1 == requiredSize;
        if (!v) {
            logger.log(Level.SEVERE, name+" size should be "+requiredSize);
            System.out.println(ArrayUtils.toString(collection));
        }
        return v;
    }

    private boolean validateDataLength() {
        boolean ret = true;
        Class obj = this.getClass();
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Definition.class)) {
                Definition definition = (Definition) method.getAnnotation(Definition.class);

                if (definition.required() != Required.REQUIRED) continue;
                try {
                    String code = (String) method.invoke(this);
                    if (code.length() == 0) continue;

                    boolean v =  code.length() >= definition.minLength() && code.length() <= definition.maxLength();

                    if (!v) {
                        String message = (definition.minLength() == definition.maxLength()) ?
                                definition.minLength()+"" : "between "+definition.minLength()+", "+definition.maxLength();
                        logger.log(Level.SEVERE, name+""+String.format("%02d", definition.position())+" length should be "+message);
                        ret = false;
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
    public String toString()
    {
        if (!validate())
            return name.concat(StringUtils.repeat("*", requiredSize)).concat("~");

        collection[0] = name;
        return StringUtils.join(collection, delimiter).concat("~");
    }
}
