package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(size = 2, name = "IEA")
public class IEA extends Segment {
    public IEA() { super(); }
    public IEA(String content) {
        super(content);
    }

    public String getNumberOfIncludedFunctionalGroups() { return collection[1]; }
    public String getInterchangeControlNumber() { return collection[2]; }

    public void setNumberOfIncludedFunctionalGroups(String s) { collection[1] = s; }
    public void setInterchangeControlNumber(String s) { collection[2] = s; }
}
