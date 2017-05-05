package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 2, name = "SE")
public class SE extends Segment {
    public SE() {super();}
    public SE(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 10)
    public String getTransactionSegmentCount() { return getField(1); }

    @Definition(position = 2, minLength = 4, maxLength = 9)
    public String getTransactionSetControlNumber() { return getField(2); }

    public void setTransactionSegmentCount(String s) { setField(1,s); }
    public void setTransactionSetControlNumber(String s) { setField(2,s); }
}
