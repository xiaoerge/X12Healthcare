package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 3, name = "ST")
public class ST extends Segment {
    public ST() {super();}
    public ST(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 3, maxLength = 3)
    public String getTransactionSetIDCode() { return getField(1); }

    @Definition(position = 2, minLength = 4, maxLength = 9)
    public String getTransactionSetControlNumber() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 35)
    public String getImplementationConventionReference() { return getField(3); }

    public void setTransactionSetIDCode(String s) { setField(1,s); }
    public void setTransactionSetControlNumber(String s) { setField(2,s); }
    public void setImplementationConventionReference(String s) { setField(3,s); }
}
