package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 1, name = "LE")
public class LE extends Segment {
    public LE() {super();}
    public LE(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 4)
    public String getLoopIdentifierCode() { return collection[1]; }

    public void setLoopIdentifierCode(String s) { collection[1] = s; }
}
