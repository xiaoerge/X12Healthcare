package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 24, name = "TS3")
public class TS3 extends Segment {
    public TS3() {super();}
    public TS3(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 2)
    public String getFacilityCodeValue() { return getField(2); }

    @Definition(position = 3, minLength = 8, maxLength = 8)
    public String getDate() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 15)
    public String getQuantity() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 18)
    public String getMonetaryAmount4() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 18)
    public String getMonetaryAmount5() { return getField(9); }

    @Definition(position = 10, minLength = 1, maxLength = 18)
    public String getMonetaryAmount6() { return getField(10); }

    @Definition(position = 11, minLength = 1, maxLength = 18)
    public String getMonetaryAmount7() { return getField(11); }

    @Definition(position = 12, minLength = 1, maxLength = 18)
    public String getMonetaryAmount8() { return getField(12); }

    @Definition(position = 13, minLength = 1, maxLength = 18)
    public String getMonetaryAmount9() { return getField(13); }

    @Definition(position = 14, minLength = 1, maxLength = 18)
    public String getMonetaryAmount10() { return getField(14); }

    @Definition(position = 15, minLength = 1, maxLength = 18)
    public String getMonetaryAmount11() { return getField(15); }

    @Definition(position = 16, minLength = 1, maxLength = 18)
    public String getMonetaryAmount12() { return getField(16); }

    @Definition(position = 17, minLength = 1, maxLength = 18)
    public String getMonetaryAmount13() { return getField(17); }

    @Definition(position = 18, minLength = 1, maxLength = 18)
    public String getMonetaryAmount14() { return getField(18); }

    @Definition(position = 19, minLength = 1, maxLength = 18)
    public String getMonetaryAmount15() { return getField(19); }

    @Definition(position = 20, minLength = 1, maxLength = 18)
    public String getMonetaryAmount16() { return getField(20); }

    @Definition(position = 21, minLength = 1, maxLength = 18)
    public String getMonetaryAmount17() { return getField(21); }

    @Definition(position = 22, minLength = 1, maxLength = 18)
    public String getMonetaryAmount18() { return getField(22); }

    @Definition(position = 23, minLength = 1, maxLength = 15)
    public String getQuantity2() { return getField(23); }

    @Definition(position = 24, minLength = 1, maxLength = 18)
    public String getMonetaryAmount20() { return getField(24); }

    public void setReferenceIdentification(String s) { setField(1,s); }
    public void setFacilityCodeValue(String s) { setField(2,s); }
    public void setDate(String s) { setField(3,s); }
    public void setQuantity(String s) { setField(4,s); }
    public void setMonetaryAmount(String s) { setField(5,s); }
    public void setMonetaryAmount2(String s) { setField(6,s); }
    public void setMonetaryAmount3(String s) { setField(7,s); }
    public void setMonetaryAmount4(String s) { setField(8,s); }
    public void setMonetaryAmount5(String s) { setField(9,s); }
    public void setMonetaryAmount6(String s) { setField(10,s); }
    public void setMonetaryAmount7(String s) { setField(11,s); }
    public void setMonetaryAmount8(String s) { setField(12,s); }
    public void setMonetaryAmount9(String s) { setField(13,s); }
    public void setMonetaryAmount10(String s) { setField(14,s); }
    public void setMonetaryAmount11(String s) { setField(15,s); }
    public void setMonetaryAmount12(String s) { setField(16,s); }
    public void setMonetaryAmount13(String s) { setField(17,s); }
    public void setMonetaryAmount14(String s) { setField(18,s); }
    public void setMonetaryAmount15(String s) { setField(19,s); }
    public void setMonetaryAmount16(String s) { setField(20,s); }
    public void setMonetaryAmount17(String s) { setField(21,s); }
    public void setMonetaryAmount18(String s) { setField(22,s); }
    public void setQuantity2(String s) { setField(23,s); }
    public void setMonetaryAmount20(String s) { setField(24,s); }
}
