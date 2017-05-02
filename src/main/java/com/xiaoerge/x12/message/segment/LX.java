package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 5, name = "LX")
public class LX extends Segment {
    public LX() { super(); }
    public LX(String content) {
        super(content);
    }
    
    @Definition(position = 1, minLength = 1, maxLength = 6)
    public String getAssignedNumber() { return collection[1]; }

    public void setAssignedNumber(String s) { collection[1] = s; }
}
