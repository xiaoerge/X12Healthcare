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
    public String getReferenceIdentification() { return collection[1]; }

    @Definition(position = 2, minLength = 8, maxLength = 8)
    public String getDate() { return collection[2]; }

    @Definition(position = 3, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[4]; }

    @Definition(position = 5, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER2() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return collection[6]; }

    @Definition(position = 7, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER3() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return collection[8]; }

    @Definition(position = 9, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER4() { return collection[9]; }

    @Definition(position = 10, minLength = 1, maxLength = 18)
    public String getMonetaryAmount4() { return collection[10]; }

    @Definition(position = 11, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER5() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 18)
    public String getMonetaryAmount5() { return collection[12]; }

    @Definition(position = 13, minLength = 3, maxLength = 52)
    public String getADJUSTMENTIDENTIFIER6() { return collection[13]; }

    @Definition(position = 14, minLength = 1, maxLength = 18)
    public String getMonetaryAmount6() { return collection[14]; }

    public void setReferenceIdentification(String s) { collection[1] = s; }
    public void setDate(String s) { collection[2] = s; }
    public void setADJUSTMENTIDENTIFIER(String s) { collection[3] = s; }
    public void setMonetaryAmount(String s) { collection[4] = s; }
    public void setADJUSTMENTIDENTIFIER2(String s) { collection[5] = s; }
    public void setMonetaryAmount2(String s) { collection[6] = s; }
    public void setADJUSTMENTIDENTIFIER3(String s) { collection[7] = s; }
    public void setMonetaryAmount3(String s) { collection[8] = s; }
    public void setADJUSTMENTIDENTIFIER4(String s) { collection[9] = s; }
    public void setMonetaryAmount4(String s) { collection[10] = s; }
    public void setADJUSTMENTIDENTIFIER5(String s) { collection[11] = s; }
    public void setMonetaryAmount5(String s) { collection[12] = s; }
    public void setADJUSTMENTIDENTIFIER6(String s) { collection[13] = s; }
    public void setMonetaryAmount6(String s) { collection[14] = s; }
}
