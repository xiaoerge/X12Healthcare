package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageBase;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class Segment extends MessageBase
{
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

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


        if (c.length() > 0 && !c.startsWith(name)) {
            logger.error(String.format("Invalid segment constructor %s for message %s", name, c));
        }
        else parse();
    }

    private void parse() {
        collection = new String[fieldSize+1];
        collection[0] = name;
        for (int i = 1; i < collection.length; i++) collection[i] = "";

        if (content.length() > 0){
            if (content.charAt(content.length() - 1) != '~') {
                parseError = true;
                logger.info(name+" parse()");
                logger.warn(name+" missing segment terminator", content);
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
        throw new NotImplementedException();
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
        boolean v = name.length() > 0 && collection[0].equals(name);
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
                        logger.warn(name+" validateDataLength()");
                        String message = (definition.minLength() == definition.maxLength()) ?
                                definition.minLength()+"" : "between "+definition.minLength()+", "+definition.maxLength();
                        logger.warn(name+""+String.format("%02d", definition.position())+" length should be "+message+" ("+code+")");
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
    public String toX12String() {

        if (isEmpty()) return "";
        if (!validate()) return name.concat(StringUtils.repeat("*", fieldSize)).concat("~");

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

    @Override
    public boolean isEmpty() {
        boolean ret = true;
        for (int i = 1; i < collection.length; i++) {
            if (collection[i].length() > 0) return false;
        }
        return true;
    }
}
