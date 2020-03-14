package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 14, name = "CLP")
public class CLP extends Segment {
    public CLP() {super();}
    public CLP(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 38)
    public String getClaimSubmittersIdentifier() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 2)
    public String getClaimStatusCode() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 2)
    public String getClaimFilingIndicatorCode() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 2)
    public String getFacilityCodeValue() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 1)
    public String getClaimFrequencyTypeCode() { return getField(9); }

    @Definition(position = 10, minLength = 1, maxLength = 2)
    public String getPatientStatusCode() { return getField(10); }

    @Definition(position = 11, minLength = 1, maxLength = 4)
    public String getDiagnosisRelatedGroupCode() { return getField(11); }

    @Definition(position = 12, minLength = 1, maxLength = 15)
    public String getQuantity() { return getField(12); }

    @Definition(position = 13, minLength = 1, maxLength = 10)
    public String getPercentageAsDecimal() { return getField(13); }

    @Definition(position = 14, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode() { return getField(14); }

    public void setClaimSubmittersIdentifier(String s) { setField(1,s); }
    public void setClaimStatusCode(String s) { setField(2,s); }
    public void setMonetaryAmount(String s) { setField(3,s); }
    public void setMonetaryAmount2(String s) { setField(4,s); }
    public void setMonetaryAmount3(String s) { setField(5,s); }
    public void setClaimFilingIndicatorCode(String s) { setField(6,s); }
    public void setReferenceIdentification(String s) { setField(7,s); }
    public void setFacilityCodeValue(String s) { setField(8,s); }
    public void setClaimFrequencyTypeCode(String s) { setField(9,s); }
    public void setPatientStatusCode(String s) { setField(10,s); }
    public void setDiagnosisRelatedGroupCode(String s) { setField(11,s); }
    public void setQuantity(String s) { setField(12,s); }
    public void setPercentageAsDecimal(String s) { setField(13,s); }
    public void setYesNoConditionOrResponseCode(String s) { setField(14,s); }
}
