package com.xiaoerge.x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class IEA extends Segment {
    public IEA() { super(); }
    public IEA(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 2;
    }
    protected void setName() { this.name = "IEA"; }

    public String getNumberOfIncludedFunctionalGroups() { return collection[1]; }
    public String getInterchangeControlNumber() { return collection[2]; }

    public void setNumberOfIncludedFunctionalGroups(String s) { collection[1] = s; }
    public void setInterchangeControlNumber(String s) { collection[2] = s; }
}
