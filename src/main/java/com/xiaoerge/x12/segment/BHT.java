package com.xiaoerge.x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BHT extends Segment {
    public BHT() {super();}
    public BHT(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 6;
    }
    protected void setName() { this.name = "BHT"; }

    public String getHierarchicalStructureCode() { return collection[1]; }
    public String getTransactionSetPurposeCode() { return collection[2]; }
    public String getReferenceIdentification() { return collection[3]; }
    public String getDate() { return collection[4]; }
    public String getTime() { return collection[5]; }
    public String getTransactionTypeCode() { return collection[6]; }

    public void setHierarchicalStructureCode(String s) { collection[1] = s; }
    public void setTransactionSetPurposeCode(String s) { collection[2] = s; }
    public void setReferenceIdentification(String s) { collection[3] = s; }
    public void setDate(String s) { collection[4] = s; }
    public void setTime(String s) { collection[5] = s; }
    public void setTransactionTypeCode(String s) { collection[6] = s; }
}
