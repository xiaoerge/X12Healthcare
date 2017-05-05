package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 14, name = "PLB")
public class PLB extends Segment {
    public PLB() {super();}
    public PLB(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getField(1); }

    @Definition(position = 2, minLength = 8, maxLength = 8)
    public String getDate() { return getField(2); }

    @Definition(position = 3, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return getField(4); }

    @Definition(position = 5, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER2() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return getField(6); }

    @Definition(position = 7, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER3() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return getField(8); }

    @Definition(position = 9, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER4() { return getField(9); }

    @Definition(position = 10, minLength = 1, maxLength = 18)
    public String getMonetaryAmount4() { return getField(10); }

    @Definition(position = 11, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER5() { return getField(11); }

    @Definition(position = 12, minLength = 1, maxLength = 18)
    public String getMonetaryAmount5() { return getField(12); }

    @Definition(position = 13, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER6() { return getField(13); }

    @Definition(position = 14, minLength = 1, maxLength = 18)
    public String getMonetaryAmount6() { return getField(14); }

    public void setReferenceIdentification(String s) { setField(1,s); }
    public void setDate(String s) { setField(2,s); }
    public void setADJUSTMENTIDENTIFIER(String s) { setField(3,s); }
    public void setMonetaryAmount(String s) { setField(4,s); }
    public void setADJUSTMENTIDENTIFIER2(String s) { setField(5,s); }
    public void setMonetaryAmount2(String s) { setField(6,s); }
    public void setADJUSTMENTIDENTIFIER3(String s) { setField(7,s); }
    public void setMonetaryAmount3(String s) { setField(8,s); }
    public void setADJUSTMENTIDENTIFIER4(String s) { setField(9,s); }
    public void setMonetaryAmount4(String s) { setField(10,s); }
    public void setADJUSTMENTIDENTIFIER5(String s) { setField(11,s); }
    public void setMonetaryAmount5(String s) { setField(12,s); }
    public void setADJUSTMENTIDENTIFIER6(String s) { setField(13,s); }
    public void setMonetaryAmount6(String s) { setField(14,s); }
}
