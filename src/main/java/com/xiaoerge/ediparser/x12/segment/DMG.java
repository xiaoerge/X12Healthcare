package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Definition;
import com.xiaoerge.ediparser.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 11, name = "DMG")
public class DMG extends Segment {
    public DMG() { super(); }
    public DMG(String content) {
        super(content);
    }
    
    @Definition(position = 1, minLength = 2, maxLength = 3)
    public String getDateTimePeriodFormatQualifier() { return getByDefinition(); }

    @Definition(position = 2, minLength = 1, maxLength = 35)
    public String getDateTimePeriod() { return getByDefinition(); }

    @Definition(position = 3, minLength = 1, maxLength = 1)
    public String getGenderCode() { return getByDefinition(); }

    @Definition(position = 4, minLength = 1, maxLength = 1)
    public String getMaritalStatusCode() { return getByDefinition(); }

    @Definition(position = 5, minLength = 1, maxLength = 10)
    public String getCompositeRaceOrEthnicityInformation() { return getByDefinition(); }

    @Definition(position = 6, minLength = 1, maxLength = 2)
    public String getCitizenshipStatusCode() { return getByDefinition(); }

    @Definition(position = 7, minLength = 2, maxLength = 3)
    public String getCountryCode() { return getByDefinition(); }

    @Definition(position = 8, minLength = 1, maxLength = 2)
    public String getBasisOfVerificationCode() { return getByDefinition(); }

    @Definition(position = 9, minLength = 1, maxLength = 15)
    public String getQuantity() { return getByDefinition(); }

    @Definition(position = 10, minLength = 1, maxLength = 13)
    public String getCodeListQualifierCode() { return getByDefinition(); }

    @Definition(position = 11, minLength = 1, maxLength = 30)
    public String getIndustryCode() { return getByDefinition(); }

    public void setDateTimePeriodFormatQualifier(String s) { collection[1] = s; }
    public void setDateTimePeriod(String s) { collection[2] = s; }
    public void setGenderCode(String s) { collection[3] = s; }
    public void setMaritalStatusCode(String s) { collection[4] = s; }
    public void setCompositeRaceOrEthnicityInformation(String s) { collection[5] = s; }
    public void setCitizenshipStatusCode(String s) { collection[6] = s; }
    public void setCountryCode(String s) { collection[7] = s; }
    public void setBasisOfVerificationCode(String s) { collection[8] = s; }
    public void setQuantity(String s) { collection[9] = s; }
    public void setCodeListQualifierCode(String s) { collection[10] = s; }
    public void setIndustryCode(String s) { collection[11] = s; }
}
