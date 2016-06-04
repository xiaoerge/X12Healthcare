package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;
import com.xiaoerge.healthcare.x12.enumeration.Required;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(requiredSize = 2, fieldSize = 4, name = "REF")
public class REF extends Segment {
    public REF() {
        super();
    }
    public REF(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 3, codeValues = {"0B", "1C", "1D", "1J", "4A", "CT", "EL", "EO", "HPI", "JD", "N5", "N7", "Q4", "SY", "TJ"})
    public String getReferenceIdentificationQualifier() {return collection[1];}

    @Definition(position = 2, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() {return collection[2];}

    @Definition(position = 3, minLength = 1, maxLength = 80)
    public String getDescription() {return collection[3];}

    @Definition(position = 4, minLength = 1, maxLength = 1)
    public String getReferenceIdentifier() {return collection[4];}

    public void setReferenceIdentificationQualifier(String s) { collection[1] = s;}
    public void setReferenceIdentification(String s) { collection[2] = s;}
    public void setDescription(String s) { collection[3] = s;}
    public void setReferenceIdentifier(String s) { collection[4] = s;}
}
