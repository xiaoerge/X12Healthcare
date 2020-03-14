package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 11, name = "DMG")
public class DMG extends Segment {
    public DMG() { super(); }
    public DMG(String content, MessageFormat mf) {
        super(content, mf);
    }
    
    @Definition(position = 1, minLength = 2, maxLength = 3)
    public String getDateTimePeriodFormatQualifier() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 35)
    public String getDateTimePeriod() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 1)
    public String getGenderCode() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 1)
    public String getMaritalStatusCode() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 10)
    public String getCompositeRaceOrEthnicityInformation() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 2)
    public String getCitizenshipStatusCode() { return getField(6); }

    @Definition(position = 7, minLength = 2, maxLength = 3)
    public String getCountryCode() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 2)
    public String getBasisOfVerificationCode() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 15)
    public String getQuantity() { return getField(9); }

    @Definition(position = 10, minLength = 1, maxLength = 13)
    public String getCodeListQualifierCode() { return getField(10); }

    @Definition(position = 11, minLength = 1, maxLength = 30)
    public String getIndustryCode() { return getField(11); }

    public void setDateTimePeriodFormatQualifier(String s) { setField(1,s); }
    public void setDateTimePeriod(String s) { setField(2,s); }
    public void setGenderCode(String s) { setField(3,s); }
    public void setMaritalStatusCode(String s) { setField(4,s); }
    public void setCompositeRaceOrEthnicityInformation(String s) { setField(5,s); }
    public void setCitizenshipStatusCode(String s) { setField(6,s); }
    public void setCountryCode(String s) { setField(7,s); }
    public void setBasisOfVerificationCode(String s) { setField(8,s); }
    public void setQuantity(String s) { setField(9,s); }
    public void setCodeListQualifierCode(String s) { setField(10,s); }
    public void setIndustryCode(String s) { setField(11,s); }
}
