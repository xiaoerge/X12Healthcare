package x12.segment;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
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
        this("","*");
    }
    public Segment(String content, String delimiter) {
        this.parseError = false;
        this.content = content;
        this.delimiter = delimiter;

        setSize();
        setName();
        parse();
    }

    private void parse() {
        if (content.length() == 0) {
            this.collection = new String[size+1];
            this.collection[0] = name;
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
        return !parseError || collection.length-1 <= size;
    }
    public String toString()
    {
        return StringUtils.join(collection, delimiter).concat("~");
    }
}
