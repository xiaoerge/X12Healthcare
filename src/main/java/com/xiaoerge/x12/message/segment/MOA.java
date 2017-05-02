package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 9, name = "MOA")
public class MOA extends Segment {
    public MOA() {super();}
    public MOA(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 10)
    public String getPercentageAsDecimal() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 50)
    public String getReferenceIdentification2() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 50)
    public String getReferenceIdentification3() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 50)
    public String getReferenceIdentification4() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 50)
    public String getReferenceIdentification5() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return collection[9]; }

    public void setPercentageAsDecimal(String s) { collection[1] = s; }
    public void setMonetaryAmount(String s) { collection[2] = s; }
    public void setReferenceIdentification(String s) { collection[3] = s; }
    public void setReferenceIdentification2(String s) { collection[4] = s; }
    public void setReferenceIdentification3(String s) { collection[5] = s; }
    public void setReferenceIdentification4(String s) { collection[6] = s; }
    public void setReferenceIdentification5(String s) { collection[7] = s; }
    public void setMonetaryAmount2(String s) { collection[8] = s; }
    public void setMonetaryAmount3(String s) { collection[9] = s; }
}
