package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 2, name = "GE")
public class GE extends Segment {
    public GE() {super();}
    public GE(String content) {
        super(content);
    }

    public String getNumberOfTransactionsSetsIncluded() { return collection[1]; }
    public String getGroupControlNumber() { return collection[2]; }

    public void setNumberOfTransactionsSetsIncluded(String s) { collection[1] = s; }
    public void setGroupControlNumber(String s) { collection[2] = s; }
}
