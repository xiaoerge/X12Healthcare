package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Definition;
import com.xiaoerge.ediparser.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "TRN")
public class TRN extends Segment {
    public TRN() { super(); }
    public TRN(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getTraceTypeCode() { return getByDefinition(); }

    @Definition(position = 2, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getByDefinition(); }

    @Definition(position = 3, minLength = 10, maxLength = 10)
    public String getOriginatingCompanyIdentifier() { return getByDefinition(); }

    @Definition(position = 4, minLength = 1, maxLength = 50)
    public String getReferenceIdentification2() { return getByDefinition(); }

    public void setTraceTypeCode(String s) { collection[1] = s; }
    public void setReferenceIdentification(String s) { collection[2] = s; }
    public void setOriginatingCompanyIdentifier(String s) { collection[3] = s; }
    public void setReferenceIdentification2(String s) { collection[4] = s; }
}
