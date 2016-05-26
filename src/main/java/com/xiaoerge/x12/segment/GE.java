package com.xiaoerge.x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class GE extends Segment {
    public GE() {super();}
    public GE(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 2;
    }
    protected void setName() { this.name = "GE"; }

    public String getNumberOfTransactionsSetsIncluded() { return collection[1]; }
    public String getGroupControlNumber() { return collection[2]; }

    public void setNumberOfTransactionsSetsIncluded(String s) { collection[1] = s; }
    public void setGroupControlNumber(String s) { collection[2] = s; }
}
