package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 19, name = "CAS")
public class CAS extends Segment {
    public CAS() {super();}
    public CAS(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getClaimAdjustmentGroupCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 5)
    public String getClaimAdjustmentReasonCode() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 15)
    public String getQuantity() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 5)
    public String getClaimAdjustmentReasonCode2() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 15)
    public String getQuantity2() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 5)
    public String getClaimAdjustmentReasonCode3() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return collection[9]; }

    @Definition(position = 10, minLength = 1, maxLength = 15)
    public String getQuantity3() { return collection[10]; }

    @Definition(position = 11, minLength = 1, maxLength = 5)
    public String getClaimAdjustmentReasonCode4() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 18)
    public String getMonetaryAmount4() { return collection[12]; }

    @Definition(position = 13, minLength = 1, maxLength = 15)
    public String getQuantity4() { return collection[13]; }

    @Definition(position = 14, minLength = 1, maxLength = 5)
    public String getClaimAdjustmentReasonCode5() { return collection[14]; }

    @Definition(position = 15, minLength = 1, maxLength = 18)
    public String getMonetaryAmount5() { return collection[15]; }

    @Definition(position = 16, minLength = 1, maxLength = 15)
    public String getQuantity5() { return collection[16]; }

    @Definition(position = 17, minLength = 1, maxLength = 5)
    public String getClaimAdjustmentReasonCode6() { return collection[17]; }

    @Definition(position = 18, minLength = 1, maxLength = 18)
    public String getMonetaryAmount6() { return collection[18]; }

    @Definition(position = 19, minLength = 1, maxLength = 15)
    public String getQuantity6() { return collection[19]; }

    public void setClaimAdjustmentGroupCode(String s) { collection[1] = s; }
    public void setClaimAdjustmentReasonCode(String s) { collection[2] = s; }
    public void setMonetaryAmount(String s) { collection[3] = s; }
    public void setQuantity(String s) { collection[4] = s; }
    public void setClaimAdjustmentReasonCode2(String s) { collection[5] = s; }
    public void setMonetaryAmount2(String s) { collection[6] = s; }
    public void setQuantity2(String s) { collection[7] = s; }
    public void setClaimAdjustmentReasonCode3(String s) { collection[8] = s; }
    public void setMonetaryAmount3(String s) { collection[9] = s; }
    public void setQuantity3(String s) { collection[10] = s; }
    public void setClaimAdjustmentReasonCode4(String s) { collection[11] = s; }
    public void setMonetaryAmount4(String s) { collection[12] = s; }
    public void setQuantity4(String s) { collection[13] = s; }
    public void setClaimAdjustmentReasonCode5(String s) { collection[14] = s; }
    public void setMonetaryAmount5(String s) { collection[15] = s; }
    public void setQuantity5(String s) { collection[16] = s; }
    public void setClaimAdjustmentReasonCode6(String s) { collection[17] = s; }
    public void setMonetaryAmount6(String s) { collection[18] = s; }
    public void setQuantity6(String s) { collection[19] = s; }
}
