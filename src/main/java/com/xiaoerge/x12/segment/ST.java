package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 3, name = "ST")
public class ST extends Segment {
    public ST() {super();}
    public ST(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 3, maxLength = 3)
    public String getTransactionSetIDCode() { return getByPosition(); }

    @Definition(position = 2, minLength = 4, maxLength = 9)
    public String getTransactionSetControlNumber() { return getByPosition(); }

    @Definition(position = 3, minLength = 1, maxLength = 35)
    public String getImplementationConventionReference() { return getByPosition(); }

    public void setTransactionSetIDCode(String s) { collection[1] = s; }
    public void setTransactionSetControlNumber(String s) { collection[2] = s; }
    public void setImplementationConventionReference(String s) { collection[3] = s; }
}
