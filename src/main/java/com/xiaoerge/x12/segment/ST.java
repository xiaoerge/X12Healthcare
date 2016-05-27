package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(size = 3, name = "ST")
public class ST extends Segment {
    public ST() {super();}
    public ST(String content) {
        super(content);
    }

    public String getTransactionSetIDCode() { return collection[1]; }
    public String getTransactionSetControlNumber() { return collection[2]; }
    public String getImplementationConventionReference() { return collection[3]; }

    public void setTransactionSetIDCode(String s) { collection[1] = s; }
    public void setTransactionSetControlNumber(String s) { collection[2] = s; }
    public void setImplementationConventionReference(String s) { collection[3] = s; }
}
