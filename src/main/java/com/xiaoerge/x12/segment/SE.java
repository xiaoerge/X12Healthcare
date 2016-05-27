package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(size = 2, name = "SE")
public class SE extends Segment {
    public SE() {super();}
    public SE(String content) {
        super(content);
    }

    public String getTransactionSegmentCount() { return collection[1]; }
    public String getTransactionSetControlNumber() { return collection[2]; }

    public void setTransactionSegmentCount(String s) { collection[1] = s; }
    public void setTransactionSetControlNumber(String s) { collection[2] = s; }
}
