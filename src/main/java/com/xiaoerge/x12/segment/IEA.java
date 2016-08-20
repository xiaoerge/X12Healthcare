package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 2, name = "IEA")
public class IEA extends Segment {
    public IEA() { super(); }
    public IEA(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 5)
    public String getNumberOfIncludedFunctionalGroups() { return getByPosition(); }

    @Definition(position = 2, minLength = 9, maxLength = 9)
    public String getInterchangeControlNumber() { return getByPosition(); }

    public void setNumberOfIncludedFunctionalGroups(String s) { collection[1] = s; }
    public void setInterchangeControlNumber(String s) { collection[2] = s; }
}
