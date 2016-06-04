package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;
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
    protected int fieldSize;
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
            fieldSize = declaration.fieldSize();
            name = declaration.name();
        }

        parse();
    }

    private void parse() {
        collection = new String[fieldSize+1];
        collection[0] = name;
        for (int i = 1; i < collection.length; i++) collection[i] = "";

        if (content.length() > 0){
            if (content.charAt(content.length() - 1) != '~') {
                parseError = true;
                logger.log(Level.SEVERE, name+" parse()");
                logger.log(Level.SEVERE, name+" missing segment terminator");
                //collection = content.split(Pattern.quote(delimiter));
            }
            else {
                String[] pCollection = content.substring(0, content.length()-1).split(Pattern.quote(delimiter));
                int min = Math.min(collection.length, pCollection.length);
                for (int i = 0; i < min; i++) {
                    try {
                        collection[i] = pCollection[i];
                    }
                    catch (Exception ex) {
                        collection[i] = "";
                    }
                }

                if (pCollection.length > collection.length) {
                    parseError = true;
                    logger.log(Level.SEVERE, name+" parse()");
                    logger.log(Level.SEVERE, name+" field length should be less tha or equal to "+fieldSize);
                }
            }
        }
    }

    public int size() {
        return fieldSize;
    }

    public String toX12String() {
        return toString();
    }

    public boolean validate()
    {
        return !parseError && validateName() && validateFieldSize()
                && validateCodeValue() && validateDataLength();
    }

    private boolean validateName() {
        boolean v = name.length() > 0 && collection[0].equals(name);
        if (!v) {
            logger.log(Level.SEVERE, name+" validateName()");
            logger.log(Level.SEVERE, name+" Segment field does not match");
        }
        return v;
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
                        logger.log(Level.SEVERE, name+" validateCodeValue()");
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

    private boolean validateFieldSize() {
        boolean v = collection.length-1 <= fieldSize;
        if (!v) {
            logger.log(Level.SEVERE, name+" validateFieldSize()");
            logger.log(Level.SEVERE, name+" size should be "+fieldSize);
        }
        return v;
    }

    private boolean validateDataLength() {
        boolean ret = true;
        Class obj = this.getClass();
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Definition.class)) {
                Definition definition = (Definition) method.getAnnotation(Definition.class);

                try {
                    String code = (String) method.invoke(this);
                    if (code.length() == 0) continue;

                    boolean v =  code.length() >= definition.minLength() && code.length() <= definition.maxLength();

                    if (!v) {
                        logger.log(Level.SEVERE, name+" validateDataLength()");
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
            return name.concat(StringUtils.repeat("*", fieldSize)).concat("~");

        collection[0] = name;
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
        builder.append("~");

        return builder.toString();
    }
}
