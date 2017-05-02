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
    public String getHealthCareCodeInformation1() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation2() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation3() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation4() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation5() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation6() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation7() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation8() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 1)
    public String getHealthCareCodeInformation9() { return collection[9]; }

    @Definition(position = 10, minLength = 1, maxLength = 13)
    public String getHealthCareCodeInformation10() { return collection[10]; }

    @Definition(position = 11, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation11() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 30)
    public String getHealthCareCodeInformation12() { return collection[12]; }

    public void setHealthCareCodeInformation1(String s) { collection[1] = s; }
    public void setHealthCareCodeInformation2(String s) { collection[2] = s; }
    public void setHealthCareCodeInformation3(String s) { collection[3] = s; }
    public void setHealthCareCodeInformation4(String s) { collection[4] = s; }
    public void setHealthCareCodeInformation5(String s) { collection[5] = s; }
    public void setHealthCareCodeInformation6(String s) { collection[6] = s; }
    public void setHealthCareCodeInformation7(String s) { collection[7] = s; }
    public void setHealthCareCodeInformation8(String s) { collection[8] = s; }
    public void setHealthCareCodeInformation9(String s) { collection[9] = s; }
    public void setHealthCareCodeInformation10(String s) { collection[10] = s; }
    public void setHealthCareCodeInformation11(String s) { collection[11] = s; }
    public void setHealthCareCodeInformation12(String s) { collection[12] = s; }
}
