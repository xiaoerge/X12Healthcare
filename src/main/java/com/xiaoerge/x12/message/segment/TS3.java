package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 24, name = "TS3")
public class TS3 extends Segment {
    public TS3() {super();}
    public TS3(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 2)
    public String getFacilityCodeValue() { return collection[2]; }

    @Definition(position = 3, minLength = 8, maxLength = 8)
    public String getDate() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 15)
    public String getQuantity() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 18)
    public String getMonetaryAmount4() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 18)
    public String getMonetaryAmount5() { return collection[9]; }

    @Definition(position = 10, minLength = 1, maxLength = 18)
    public String getMonetaryAmount6() { return collection[10]; }

    @Definition(position = 11, minLength = 1, maxLength = 18)
    public String getMonetaryAmount7() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 18)
    public String getMonetaryAmount8() { return collection[12]; }

    @Definition(position = 13, minLength = 1, maxLength = 18)
    public String getMonetaryAmount9() { return collection[13]; }

    @Definition(position = 14, minLength = 1, maxLength = 18)
    public String getMonetaryAmount10() { return collection[14]; }

    @Definition(position = 15, minLength = 1, maxLength = 18)
    public String getMonetaryAmount11() { return collection[15]; }

    @Definition(position = 16, minLength = 1, maxLength = 18)
    public String getMonetaryAmount12() { return collection[16]; }

    @Definition(position = 17, minLength = 1, maxLength = 18)
    public String getMonetaryAmount13() { return collection[17]; }

    @Definition(position = 18, minLength = 1, maxLength = 18)
    public String getMonetaryAmount14() { return collection[18]; }

    @Definition(position = 19, minLength = 1, maxLength = 18)
    public String getMonetaryAmount15() { return collection[19]; }

    @Definition(position = 20, minLength = 1, maxLength = 18)
    public String getMonetaryAmount16() { return collection[20]; }

    @Definition(position = 21, minLength = 1, maxLength = 18)
    public String getMonetaryAmount17() { return collection[21]; }

    @Definition(position = 22, minLength = 1, maxLength = 18)
    public String getMonetaryAmount18() { return collection[22]; }

    @Definition(position = 23, minLength = 1, maxLength = 15)
    public String getQuantity2() { return collection[23]; }

    @Definition(position = 24, minLength = 1, maxLength = 18)
    public String getMonetaryAmount20() { return collection[24]; }

    public void setReferenceIdentification(String s) { collection[1] = s; }
    public void setFacilityCodeValue(String s) { collection[2] = s; }
    public void setDate(String s) { collection[3] = s; }
    public void setQuantity(String s) { collection[4] = s; }
    public void setMonetaryAmount(String s) { collection[5] = s; }
    public void setMonetaryAmount2(String s) { collection[6] = s; }
    public void setMonetaryAmount3(String s) { collection[7] = s; }
    public void setMonetaryAmount4(String s) { collection[8] = s; }
    public void setMonetaryAmount5(String s) { collection[9] = s; }
    public void setMonetaryAmount6(String s) { collection[10] = s; }
    public void setMonetaryAmount7(String s) { collection[11] = s; }
    public void setMonetaryAmount8(String s) { collection[12] = s; }
    public void setMonetaryAmount9(String s) { collection[13] = s; }
    public void setMonetaryAmount10(String s) { collection[14] = s; }
    public void setMonetaryAmount11(String s) { collection[15] = s; }
    public void setMonetaryAmount12(String s) { collection[16] = s; }
    public void setMonetaryAmount13(String s) { collection[17] = s; }
    public void setMonetaryAmount14(String s) { collection[18] = s; }
    public void setMonetaryAmount15(String s) { collection[19] = s; }
    public void setMonetaryAmount16(String s) { collection[20] = s; }
    public void setMonetaryAmount17(String s) { collection[21] = s; }
    public void setMonetaryAmount18(String s) { collection[22] = s; }
    public void setQuantity2(String s) { collection[23] = s; }
    public void setMonetaryAmount20(String s) { collection[24] = s; }
}
