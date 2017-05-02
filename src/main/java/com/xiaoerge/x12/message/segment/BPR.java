package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 21, name = "BPR")
public class BPR extends Segment {
    public BPR() {super();}
    public BPR(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getTransactionHandlingCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 1)
    public String getCreditDebitFlagCode() { return collection[3]; }

    @Definition(position = 4, minLength = 3, maxLength = 3)
    public String getPaymentMethodCode() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 10)
    public String getPaymentFormatCode() { return collection[5]; }

    @Definition(position = 6, minLength = 2, maxLength = 2)
    public String getDFIIDNumberQualifier() { return collection[6]; }

    @Definition(position = 7, minLength = 3, maxLength = 12)
    public String getDFIIdentificationNumber() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 3)
    public String getAccountNumberQualifier() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 35)
    public String getAccountNumber() { return collection[9]; }

    @Definition(position = 10, minLength = 10, maxLength = 10)
    public String getOriginatingCompanyIdentifier() { return collection[10]; }

    @Definition(position = 11, minLength = 9, maxLength = 9)
    public String getOriginatingCompanySupplementalCode() { return collection[11]; }

    @Definition(position = 12, minLength = 2, maxLength = 2)
    public String getDFIIDNumberQualifier2() { return collection[12]; }

    @Definition(position = 13, minLength = 3, maxLength = 12)
    public String getDFIIdentificationNumber2() { return collection[13]; }

    @Definition(position = 14, minLength = 1, maxLength = 3)
    public String getAccountNumberQualifier2() { return collection[14]; }

    @Definition(position = 15, minLength = 1, maxLength = 35)
    public String getAccountNumber2() { return collection[15]; }

    @Definition(position = 16, minLength = 8, maxLength = 8)
    public String getDate() { return collection[16]; }

    @Definition(position = 17, minLength = 1, maxLength = 3)
    public String getBusinessFunctionCode() { return collection[17]; }

    @Definition(position = 18, minLength = 2, maxLength = 2)
    public String getDFIIDNumberQualifier3() { return collection[18]; }

    @Definition(position = 19, minLength = 3, maxLength = 12)
    public String getDFIIdentificationNumber3() { return collection[19]; }

    @Definition(position = 20, minLength = 1, maxLength = 3)
    public String getAccountNumberQualifier3() { return collection[20]; }

    @Definition(position = 21, minLength = 1, maxLength = 35)
    public String getAccountNumber3() { return collection[21]; }

    public void setTransactionHandlingCode(String s) { collection[1] = s; }
    public void setMonetaryAmount(String s) { collection[2] = s; }
    public void setCreditDebitFlagCode(String s) { collection[3] = s; }
    public void setPaymentMethodCode(String s) { collection[4] = s; }
    public void setPaymentFormatCode(String s) { collection[5] = s; }
    public void setDFIIDNumberQualifier(String s) { collection[6] = s; }
    public void setDFIIdentificationNumber(String s) { collection[7] = s; }
    public void setAccountNumberQualifier(String s) { collection[8] = s; }
    public void setAccountNumber(String s) { collection[9] = s; }
    public void setOriginatingCompanyIdentifier(String s) { collection[10] = s; }
    public void setOriginatingCompanySupplementalCode(String s) { collection[11] = s; }
    public void setDFIIDNumberQualifier2(String s) { collection[12] = s; }
    public void setDFIIdentificationNumber2(String s) { collection[13] = s; }
    public void setAccountNumberQualifier2(String s) { collection[14] = s; }
    public void setAccountNumber2(String s) { collection[15] = s; }
    public void setDate(String s) { collection[16] = s; }
    public void setBusinessFunctionCode(String s) { collection[17] = s; }
    public void setDFIIDNumberQualifier3(String s) { collection[18] = s; }
    public void setDFIIdentificationNumber3(String s) { collection[19] = s; }
    public void setAccountNumberQualifier3(String s) { collection[20] = s; }
    public void setAccountNumber3(String s) { collection[21] = s; }
}
