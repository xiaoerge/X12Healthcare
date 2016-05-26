package com.xiaoerge.x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class SE extends Segment {
    public SE() {super();}
    public SE(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 2;
    }
    protected void setName() { this.name = "SE"; }

    public String getTransactionSegmentCount() { return collection[1]; }
    public String getTransactionSetControlNumber() { return collection[2]; }

    public void setTransactionSegmentCount(String s) { collection[1] = s; }
    public void setTransactionSetControlNumber(String s) { collection[2] = s; }
}
