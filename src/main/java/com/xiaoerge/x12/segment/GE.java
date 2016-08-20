package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 2, name = "GE")
public class GE extends Segment {
    public GE() {super();}
    public GE(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 6)
    public String getNumberOfTransactionsSetsIncluded() { return getByPosition(); }

    @Definition(position = 2, minLength = 1, maxLength = 9)
    public String getGroupControlNumber() { return getByPosition(); }

    public void setNumberOfTransactionsSetsIncluded(String s) { collection[1] = s; }
    public void setGroupControlNumber(String s) { collection[2] = s; }
}
