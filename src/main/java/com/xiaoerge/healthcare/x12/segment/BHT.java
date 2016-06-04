package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.enumeration.Required;
import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(requiredSize = 5, fieldSize = 6, name = "BHT")
public class BHT extends Segment {
    public BHT() {super();}
    public BHT(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 4, maxLength = 4)
    public String getHierarchicalStructureCode() { return collection[1]; }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getTransactionSetPurposeCode() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return collection[3]; }

    @Definition(position = 4, minLength = 8, maxLength = 8)
    public String getDate() { return collection[4]; }

    @Definition(position = 5, minLength = 4, maxLength = 8)
    public String getTime() { return collection[5]; }

    @Definition(position = 6, minLength = 2, maxLength = 2)
    public String getTransactionTypeCode() { return collection[6]; }

    public void setHierarchicalStructureCode(String s) { collection[1] = s; }
    public void setTransactionSetPurposeCode(String s) { collection[2] = s; }
    public void setReferenceIdentification(String s) { collection[3] = s; }
    public void setDate(String s) { collection[4] = s; }
    public void setTime(String s) { collection[5] = s; }
    public void setTransactionTypeCode(String s) { collection[6] = s; }
}
