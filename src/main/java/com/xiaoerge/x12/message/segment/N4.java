package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 7, name = "N4")
public class N4 extends Segment {
    public N4() {super();}
    public N4(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 2, maxLength = 30)
    public String getCityName() { return getField(1); }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getStateOrProvinceCode() { return getField(2); }

    @Definition(position = 3, minLength = 3, maxLength = 15)
    public String getPostalCode() { return getField(3); }

    @Definition(position = 4, minLength = 2, maxLength = 3)
    public String getCountryCode() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 2)
    public String getLocationQualifier() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 30)
    public String getLocationIdentifier() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 3)
    public String getCountrySubdivisionCode() { return getField(7); }

    public void setCityName(String s) { setField(1,s); }
    public void setStateOrProvinceCode(String s) { setField(2,s); }
    public void setPostalCode(String s) { setField(3,s); }
    public void setCountryCode(String s) { setField(4,s); }
    public void setLocationQualifier(String s) { setField(5,s); }
    public void setLocationIdentifier(String s) { setField(6,s); }
    public void setCountrySubdivisionCode(String s) { setField(7,s); }
}
