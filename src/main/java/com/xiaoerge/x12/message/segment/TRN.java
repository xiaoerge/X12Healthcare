package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "TRN")
public class TRN extends Segment {
    public TRN() { super(); }
    public TRN(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getTraceTypeCode() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getField(2); }

    @Definition(position = 3, minLength = 10, maxLength = 10)
    public String getOriginatingCompanyIdentifier() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 50)
    public String getReferenceIdentification2() { return getField(4); }

    public void setTraceTypeCode(String s) { setField(1,s); }
    public void setReferenceIdentification(String s) { setField(2,s); }
    public void setOriginatingCompanyIdentifier(String s) { setField(3,s); }
    public void setReferenceIdentification2(String s) { setField(4,s); }
}
