package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 1, name = "LS")
public class LS extends Segment {
    public LS() {super();}
    public LS(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 4)
    public String getLoopIdentifierCode() { return collection[1]; }

    public void setLoopIdentifierCode(String s) { collection[1] = s; }
}