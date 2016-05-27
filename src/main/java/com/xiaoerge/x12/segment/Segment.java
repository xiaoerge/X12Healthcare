package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Created by xiaoerge on 5/23/16.
 */
public abstract class Segment
{
    private boolean parseError;
    protected int size;
    protected String name;
    protected String content;
    protected String delimiter;
    protected String[] collection;

    public Segment() {
        this("");
    }
    public Segment(String content) {
        this.parseError = false;
        this.content = content;
        this.delimiter = "*";

        Class obj = this.getClass();
        if (obj.isAnnotationPresent(Declaration.class)) {
            Declaration declaration = (Declaration) obj.getAnnotation(Declaration.class);
            this.size = declaration.size();
            this.name = declaration.name();
        }

        parse();
    }

    private void parse() {
        if (content.length() == 0) {
            this.collection = new String[size+1];
            collection[0] = name;
            return;
        }

        if (content.charAt(content.length() - 1) != '~') {
            parseError = true;
            this.collection = content.split(Pattern.quote(delimiter));
        }
        else {
            this.collection = content.substring(0, content.length()-1).split(Pattern.quote(delimiter));
        }
    }

    public int size() {
        return size;
    }
    public boolean validate()
    {
        return !parseError && validateName() && size != 0 && validateSize();
    }

    private boolean validateName() {
        return name.length() > 0 && collection[0].equals(name);
    }

    private boolean validateSize() {
        return size != 0 && collection.length-1 == size;
    }

    public String toString()
    {
        if (!validate())
            return name.concat(StringUtils.repeat("*", size)).concat("~");

        collection[0] = name;
        return StringUtils.join(collection, delimiter).concat("~");
    }
}
