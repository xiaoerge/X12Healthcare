package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 2, name = "IEA")
public class IEA extends Segment {
    public IEA() { super(); }
    public IEA(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 5)
    public String getNumberOfIncludedFunctionalGroups() { return getField(1); }

    @Definition(position = 2, minLength = 9, maxLength = 9)
    public String getInterchangeControlNumber() { return getField(2); }

    public void setNumberOfIncludedFunctionalGroups(String s) { setField(1,s); }
    public void setInterchangeControlNumber(String s) { setField(2,s); }
}
