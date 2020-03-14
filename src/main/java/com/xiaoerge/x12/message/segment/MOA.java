package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 9, name = "MOA")
public class MOA extends Segment {
    public MOA() {super();}
    public MOA(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 10)
    public String getPercentageAsDecimal() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 50)
    public String getReferenceIdentification2() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 50)
    public String getReferenceIdentification3() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 50)
    public String getReferenceIdentification4() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 50)
    public String getReferenceIdentification5() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return getField(9); }

    public void setPercentageAsDecimal(String s) { setField(1,s); }
    public void setMonetaryAmount(String s) { setField(2,s); }
    public void setReferenceIdentification(String s) { setField(3,s); }
    public void setReferenceIdentification2(String s) { setField(4,s); }
    public void setReferenceIdentification3(String s) { setField(5,s); }
    public void setReferenceIdentification4(String s) { setField(6,s); }
    public void setReferenceIdentification5(String s) { setField(7,s); }
    public void setMonetaryAmount2(String s) { setField(8,s); }
    public void setMonetaryAmount3(String s) { setField(9,s); }
}
