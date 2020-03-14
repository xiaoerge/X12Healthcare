package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 12, name = "HI")
public class HI extends Segment {
    public HI() { super(); }
    public HI(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation1() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation2() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation3() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation4() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation5() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation6() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation7() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation8() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 1)
    public String getHealthCareCodeInformation9() { return getField(9); }

    @Definition(position = 10, minLength = 1, maxLength = 13)
    public String getHealthCareCodeInformation10() { return getField(10); }

    @Definition(position = 11, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation11() { return getField(11); }

    @Definition(position = 12, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation12() { return getField(12); }

    public void setHealthCareCodeInformation1(String s) { setField(1,s); }
    public void setHealthCareCodeInformation2(String s) { setField(2,s); }
    public void setHealthCareCodeInformation3(String s) { setField(3,s); }
    public void setHealthCareCodeInformation4(String s) { setField(4,s); }
    public void setHealthCareCodeInformation5(String s) { setField(5,s); }
    public void setHealthCareCodeInformation6(String s) { setField(6,s); }
    public void setHealthCareCodeInformation7(String s) { setField(7,s); }
    public void setHealthCareCodeInformation8(String s) { setField(8,s); }
    public void setHealthCareCodeInformation9(String s) { setField(9,s); }
    public void setHealthCareCodeInformation10(String s) { setField(10,s); }
    public void setHealthCareCodeInformation11(String s) { setField(11,s); }
    public void setHealthCareCodeInformation12(String s) { setField(12,s); }
}
