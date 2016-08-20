package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 3, name = "AMT")
public class AMT extends Segment {
    public AMT() { super(); }
    public AMT(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 3)
    public String getAmountQualifierCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 1)
    public String getCreditDebitFlagCode() { return collection[3]; }

    public void setAmountQualifierCode(String s) { collection[1] = s; }
    public void setMonetaryAmount(String s) { collection[2] = s; }
    public void setCreditDebitFlagCode(String s) { collection[3] = s; }
}
