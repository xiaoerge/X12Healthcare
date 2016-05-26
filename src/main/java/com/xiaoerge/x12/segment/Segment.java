package com.xiaoerge.x12.segment;

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

        setSize();
        setName();
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
    protected abstract void setSize();
    protected abstract void setName();

    public int size() {
        return size;
    }
    public boolean validate()
    {
        return collection[0].equals(name) && name.length() > 0 && !parseError && size != 0 && collection.length-1 <= size;
    }
    public String toString()
    {
        if (!validate())
            return name.concat(StringUtils.repeat("*", size)).concat("~");

        collection[0] = name;
        return StringUtils.join(collection, delimiter).concat("~");
    }
}
