package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.enumeration.Required;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(size = 6, name = "BHT")
public class BHT extends Segment {
    public BHT() {super();}
    public BHT(String content) {
        super(content);
    }

    @Definition(required = Required.REQUIRED, position = 1, minLength = 4, maxLength = 4)
    public String getHierarchicalStructureCode() { return collection[1]; }

    @Definition(required = Required.REQUIRED, position = 2, minLength = 2, maxLength = 2)
    public String getTransactionSetPurposeCode() { return collection[2]; }

    @Definition(required = Required.REQUIRED, position = 3, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return collection[3]; }

    @Definition(required = Required.REQUIRED, position = 4, minLength = 8, maxLength = 8)
    public String getDate() { return collection[4]; }

    @Definition(required = Required.REQUIRED, position = 5, minLength = 4, maxLength = 8)
    public String getTime() { return collection[5]; }

    @Definition(required = Required.REQUIRED, position = 6, minLength = 2, maxLength = 2)
    public String getTransactionTypeCode() { return collection[6]; }

    public void setHierarchicalStructureCode(String s) { collection[1] = s; }
    public void setTransactionSetPurposeCode(String s) { collection[2] = s; }
    public void setReferenceIdentification(String s) { collection[3] = s; }
    public void setDate(String s) { collection[4] = s; }
    public void setTime(String s) { collection[5] = s; }
    public void setTransactionTypeCode(String s) { collection[6] = s; }
}
