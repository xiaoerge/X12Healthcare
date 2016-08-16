package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Declaration;
import com.xiaoerge.ediparser.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 7, name = "N4")
public class N4 extends Segment {
    public N4() {super();}
    public N4(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 30)
    public String getCityName() { return getByDefinition(); }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getStateOrProvinceCode() { return getByDefinition(); }

    @Definition(position = 3, minLength = 3, maxLength = 15)
    public String getPostalCode() { return getByDefinition(); }

    @Definition(position = 4, minLength = 2, maxLength = 3)
    public String getCountryCode() { return getByDefinition(); }

    @Definition(position = 5, minLength = 1, maxLength = 2)
    public String getLocationQualifier() { return getByDefinition(); }

    @Definition(position = 6, minLength = 1, maxLength = 30)
    public String getLocationIdentifier() { return getByDefinition(); }

    @Definition(position = 7, minLength = 1, maxLength = 3)
    public String getCountrySubdivisionCode() { return getByDefinition(); }

    public void setCityName(String s) { collection[1] = s; }
    public void setStateOrProvinceCode(String s) { collection[2] = s; }
    public void setPostalCode(String s) { collection[3] = s; }
    public void setCountryCode(String s) { collection[4] = s; }
    public void setLocationQualifier(String s) { collection[5] = s; }
    public void setLocationIdentifier(String s) { collection[6] = s; }
    public void setCountrySubdivisionCode(String s) { collection[7] = s; }
}
