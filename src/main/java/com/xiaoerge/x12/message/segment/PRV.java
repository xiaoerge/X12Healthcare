package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 6, name = "PRV")
public class PRV extends Segment {
    public PRV() { super(); }
    public PRV(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 3)
    public String getProviderCode() { return collection[1]; }

    @Definition(position = 2, minLength = 2, maxLength = 3)
    public String getReferenceIdentificationQualifier() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return collection[3]; }

    @Definition(position = 4, minLength = 2, maxLength = 2)
    public String getStateOrProvinceCode() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 10)
    public String getProviderSpecialtyInformation() { return collection[5]; }

    @Definition(position = 6, minLength = 3, maxLength = 3)
    public String getProviderOrganizationCode() { return collection[6]; }

    public void setProviderCode(String s) { collection[1] = s; }
    public void setReferenceIdentificationQualifier(String s) { collection[2] = s; }
    public void setReferenceIdentification(String s) { collection[3] = s; }
    public void setStateOrProvinceCode(String s) { collection[4] = s; }
    public void setProviderSpecialtyInformation(String s) { collection[5] = s; }
    public void setProviderOrganizationCode(String s) { collection[6] = s; }
}
