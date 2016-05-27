package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.enumeration.Required;
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
public abstract class Segment
{
    static Logger logger = Logger.getLogger(Segment.class.getName());

    private boolean parseError;
    protected int size;
    protected String name;
    protected String content;
    protected String delimiter;
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
            size = declaration.size();
            name = declaration.name();
        }

        parse();
    }

    private void parse() {
        if (content.length() == 0) {
            collection = new String[size+1];
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
        return size;
    }
    public boolean validate()
    {
        return !parseError && validateName() && size != 0
                && validateSize() && validateRequired()
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
                    boolean v = code.length() > 0;
                    if (!v) {
                        logger.log(Level.SEVERE, name+""+definition.position()+" is required but missing");
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
                        logger.log(Level.SEVERE, name+""+definition.position()+" is not within "+ArrayUtils.toString(definition.codeValues()));
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
        boolean v = size != 0 && collection.length-1 == size;
        if (!v) logger.log(Level.SEVERE, name+" size should be "+size);
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
                    boolean v =  code.length() >= definition.minLength() && code.length() <= definition.maxLength();
                    if (!v) {
                        logger.log(Level.SEVERE, name+""+definition.position()+" length should be between "
                                +definition.minLength()+", "+definition.maxLength());
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

    public String toString()
    {
        if (!validate())
            return name.concat(StringUtils.repeat("*", size)).concat("~");

        collection[0] = name;
        return StringUtils.join(collection, delimiter).concat("~");
    }
}
