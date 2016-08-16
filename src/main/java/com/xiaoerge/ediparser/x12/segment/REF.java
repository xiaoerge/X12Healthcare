package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Definition;
import com.xiaoerge.ediparser.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "REF")
public class REF extends Segment {
    public REF() {
        super();
    }
    public REF(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 3)
    public String getReferenceIdentificationQualifier() {return getByDefinition(); }

    @Definition(position = 2, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() {return getByDefinition(); }

    @Definition(position = 3, minLength = 1, maxLength = 80)
    public String getDescription() {return getByDefinition(); }

    @Definition(position = 4, minLength = 1, maxLength = 10)
    public String getReferenceIdentifier() {return getByDefinition(); }

    public void setReferenceIdentificationQualifier(String s) { collection[1] = s;}
    public void setReferenceIdentification(String s) { collection[2] = s;}
    public void setDescription(String s) { collection[3] = s;}
    public void setReferenceIdentifier(String s) { collection[4] = s;}
}
