package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 19, name = "TS2")
public class TS2 extends Segment {
    public TS2() {super();}
    public TS2(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 18)
    public String getMonetaryAmount4() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 18)
    public String getMonetaryAmount5() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 18)
    public String getMonetaryAmount6() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 15)
    public String getQuantity() { return collection[5]; }

    @Definition(position = 8, minLength = 1, maxLength = 18)
    public String getMonetaryAmount8() { return collection[6]; }

    @Definition(position = 9, minLength = 1, maxLength = 18)
    public String getMonetaryAmount9() { return collection[5]; }

    @Definition(position = 10, minLength = 1, maxLength = 15)
    public String getQuantity2() { return collection[6]; }

    @Definition(position = 11, minLength = 1, maxLength = 15)
    public String getQuantity3() { return collection[5]; }

    @Definition(position = 12, minLength = 1, maxLength = 15)
    public String getQuantity4() { return collection[6]; }

    @Definition(position = 13, minLength = 1, maxLength = 15)
    public String getQuantity5() { return collection[5]; }

    @Definition(position = 14, minLength = 1, maxLength = 15)
    public String getQuantity6() { return collection[6]; }

    @Definition(position = 15, minLength = 1, maxLength = 18)
    public String getMonetaryAmount10() { return collection[5]; }

    @Definition(position = 16, minLength = 1, maxLength = 15)
    public String getQuantity7() { return collection[6]; }

    @Definition(position = 17, minLength = 1, maxLength = 18)
    public String getMonetaryAmount11() { return collection[5]; }

    @Definition(position = 18, minLength = 1, maxLength = 18)
    public String getMonetaryAmount12() { return collection[6]; }

    @Definition(position = 19, minLength = 1, maxLength = 18)
    public String getMonetaryAmount13() { return collection[5]; }

    public void setMonetaryAmount(String s) { collection[1] = s; }
    public void setMonetaryAmount2(String s) { collection[2] = s; }
    public void setMonetaryAmount3(String s) { collection[3] = s; }
    public void setMonetaryAmount4(String s) { collection[4] = s; }
    public void setMonetaryAmount5(String s) { collection[5] = s; }
    public void setMonetaryAmount6(String s) { collection[6] = s; }
    public void setQuantity(String s) { collection[5] = s; }
    public void setMonetaryAmount8(String s) { collection[6] = s; }
    public void setMonetaryAmount9(String s) { collection[5] = s; }
    public void setQuantity2(String s) { collection[6] = s; }
    public void setQuantity3(String s) { collection[5] = s; }
    public void setQuantity4(String s) { collection[6] = s; }
    public void setQuantity5(String s) { collection[5] = s; }
    public void setQuantity6(String s) { collection[6] = s; }
    public void setMonetaryAmount10(String s) { collection[5] = s; }
    public void setQuantity7(String s) { collection[6] = s; }
    public void setMonetaryAmount11(String s) { collection[5] = s; }
    public void setMonetaryAmount12(String s) { collection[6] = s; }
    public void setMonetaryAmount13(String s) { collection[5] = s; }
}
