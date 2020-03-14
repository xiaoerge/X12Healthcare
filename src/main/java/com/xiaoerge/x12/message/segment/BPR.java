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
    public String getTransactionHandlingCode() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 1)
    public String getCreditDebitFlagCode() { return getField(3); }

    @Definition(position = 4, minLength = 3, maxLength = 3)
    public String getPaymentMethodCode() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 10)
    public String getPaymentFormatCode() { return getField(5); }

    @Definition(position = 6, minLength = 2, maxLength = 2)
    public String getDFIIDNumberQualifier() { return getField(6); }

    @Definition(position = 7, minLength = 3, maxLength = 12)
    public String getDFIIdentificationNumber() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 3)
    public String getAccountNumberQualifier() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 35)
    public String getAccountNumber() { return getField(9); }

    @Definition(position = 10, minLength = 10, maxLength = 10)
    public String getOriginatingCompanyIdentifier() { return getField(10); }

    @Definition(position = 11, minLength = 9, maxLength = 9)
    public String getOriginatingCompanySupplementalCode() { return getField(11); }

    @Definition(position = 12, minLength = 2, maxLength = 2)
    public String getDFIIDNumberQualifier2() { return getField(12); }

    @Definition(position = 13, minLength = 3, maxLength = 12)
    public String getDFIIdentificationNumber2() { return getField(13); }

    @Definition(position = 14, minLength = 1, maxLength = 3)
    public String getAccountNumberQualifier2() { return getField(14); }

    @Definition(position = 15, minLength = 1, maxLength = 35)
    public String getAccountNumber2() { return getField(15); }

    @Definition(position = 16, minLength = 8, maxLength = 8)
    public String getDate() { return getField(16); }

    @Definition(position = 17, minLength = 1, maxLength = 3)
    public String getBusinessFunctionCode() { return getField(17); }

    @Definition(position = 18, minLength = 2, maxLength = 2)
    public String getDFIIDNumberQualifier3() { return getField(18); }

    @Definition(position = 19, minLength = 3, maxLength = 12)
    public String getDFIIdentificationNumber3() { return getField(19); }

    @Definition(position = 20, minLength = 1, maxLength = 3)
    public String getAccountNumberQualifier3() { return getField(20); }

    @Definition(position = 21, minLength = 1, maxLength = 35)
    public String getAccountNumber3() { return getField(21); }

    public void setTransactionHandlingCode(String s) { setField(1,s); }
    public void setMonetaryAmount(String s) { setField(2,s); }
    public void setCreditDebitFlagCode(String s) { setField(3,s); }
    public void setPaymentMethodCode(String s) { setField(4,s); }
    public void setPaymentFormatCode(String s) { setField(5,s); }
    public void setDFIIDNumberQualifier(String s) { setField(6,s); }
    public void setDFIIdentificationNumber(String s) { setField(7,s); }
    public void setAccountNumberQualifier(String s) { setField(8,s); }
    public void setAccountNumber(String s) { setField(9,s); }
    public void setOriginatingCompanyIdentifier(String s) { setField(10,s); }
    public void setOriginatingCompanySupplementalCode(String s) { setField(11,s); }
    public void setDFIIDNumberQualifier2(String s) { setField(12,s); }
    public void setDFIIdentificationNumber2(String s) { setField(13,s); }
    public void setAccountNumberQualifier2(String s) { setField(14,s); }
    public void setAccountNumber2(String s) { setField(15,s); }
    public void setDate(String s) { setField(16,s); }
    public void setBusinessFunctionCode(String s) { setField(17,s); }
    public void setDFIIDNumberQualifier3(String s) { setField(18,s); }
    public void setDFIIdentificationNumber3(String s) { setField(19,s); }
    public void setAccountNumberQualifier3(String s) { setField(20,s); }
    public void setAccountNumber3(String s) { setField(21,s); }
}
