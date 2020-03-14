package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 6, name = "PRV")
public class PRV extends Segment {
    public PRV() { super(); }
    public PRV(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 3)
    public String getProviderCode() { return getField(1); }

    @Definition(position = 2, minLength = 2, maxLength = 3)
    public String getReferenceIdentificationQualifier() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getField(3); }

    @Definition(position = 4, minLength = 2, maxLength = 2)
    public String getStateOrProvinceCode() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 10)
    public String getProviderSpecialtyInformation() { return getField(5); }

    @Definition(position = 6, minLength = 3, maxLength = 3)
    public String getProviderOrganizationCode() { return getField(6); }

    public void setProviderCode(String s) { setField(1,s); }
    public void setReferenceIdentificationQualifier(String s) { setField(2,s); }
    public void setReferenceIdentification(String s) { setField(3,s); }
    public void setStateOrProvinceCode(String s) { setField(4,s); }
    public void setProviderSpecialtyInformation(String s) { setField(5,s); }
    public void setProviderOrganizationCode(String s) { setField(6,s); }
}
