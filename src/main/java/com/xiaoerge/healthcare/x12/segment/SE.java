package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.enumeration.Required;
import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(size = 2, name = "SE")
public class SE extends Segment {
    public SE() {super();}
    public SE(String content) {
        super(content);
    }

    @Definition(required = Required.REQUIRED, position = 1, minLength = 1, maxLength = 10)
    public String getTransactionSegmentCount() { return collection[1]; }

    @Definition(required = Required.REQUIRED, position = 2, minLength = 4, maxLength = 9)
    public String getTransactionSetControlNumber() { return collection[2]; }

    public void setTransactionSegmentCount(String s) { collection[1] = s; }
    public void setTransactionSetControlNumber(String s) { collection[2] = s; }
}
