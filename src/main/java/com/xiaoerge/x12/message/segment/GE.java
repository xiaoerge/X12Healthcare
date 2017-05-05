package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 2, name = "GE")
public class GE extends Segment {
    public GE() {super();}
    public GE(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 6)
    public String getNumberOfTransactionsSetsIncluded() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 9)
    public String getGroupControlNumber() { return getField(2); }

    public void setNumberOfTransactionsSetsIncluded(String s) { setField(1,s); }
    public void setGroupControlNumber(String s) { setField(2,s); }
}
