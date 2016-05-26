package com.xiaoerge.x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class ST extends Segment {
    public ST() {super();}
    public ST(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 3;
    }
    protected void setName() { this.name = "ST"; }

    public String getTransactionSetIDCode() { return collection[1]; }
    public String getTransactionSetControlNumber() { return collection[2]; }
    public String getImplementationConventionReference() { return collection[3]; }

    public void setTransactionSetIDCode(String s) { collection[1] = s; }
    public void setTransactionSetControlNumber(String s) { collection[2] = s; }
    public void setImplementationConventionReference(String s) { collection[3] = s; }
}
