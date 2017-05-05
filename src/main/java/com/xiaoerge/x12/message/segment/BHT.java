package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 6, name = "BHT")
public class BHT extends Segment {
    public BHT() {super();}
    public BHT(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 4, maxLength = 4)
    public String getHierarchicalStructureCode() { return getField(1); }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getTransactionSetPurposeCode() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getField(3); }

    @Definition(position = 4, minLength = 8, maxLength = 8)
    public String getDate() { return getField(4); }

    @Definition(position = 5, minLength = 4, maxLength = 8)
    public String getTime() { return getField(5); }

    @Definition(position = 6, minLength = 2, maxLength = 2)
    public String getTransactionTypeCode() { return getField(6); }

    public void setHierarchicalStructureCode(String s) { setField(1,s); }
    public void setTransactionSetPurposeCode(String s) { setField(2,s); }
    public void setReferenceIdentification(String s) { setField(3,s); }
    public void setDate(String s) { setField(4,s); }
    public void setTime(String s) { setField(5,s); }
    public void setTransactionTypeCode(String s) { setField(6,s); }
}
