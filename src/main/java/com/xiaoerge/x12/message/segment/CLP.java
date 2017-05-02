package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 14, name = "CLP")
public class CLP extends Segment {
    public CLP() {super();}
    public CLP(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 38)
    public String getClaimSubmittersIdentifier() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 2)
    public String getClaimStatusCode() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 18)
    public String getMonetaryAmount3() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 2)
    public String getClaimFilingIndicatorCode() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 50)
    public String getReferenceIdentification() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 2)
    public String getFacilityCodeValue() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 1)
    public String getClaimFrequencyTypeCode() { return collection[9]; }

    @Definition(position = 10, minLength = 1, maxLength = 2)
    public String getPatientStatusCode() { return collection[10]; }

    @Definition(position = 11, minLength = 1, maxLength = 4)
    public String getDiagnosisRelatedGroupCode() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 15)
    public String getQuantity() { return collection[12]; }

    @Definition(position = 13, minLength = 1, maxLength = 10)
    public String getPercentageAsDecimal() { return collection[13]; }

    @Definition(position = 14, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode() { return collection[14]; }

    public void setClaimSubmittersIdentifier(String s) { collection[1] = s; }
    public void setClaimStatusCode(String s) { collection[2] = s; }
    public void setMonetaryAmount(String s) { collection[3] = s; }
    public void setMonetaryAmount2(String s) { collection[4] = s; }
    public void setMonetaryAmount3(String s) { collection[5] = s; }
    public void setClaimFilingIndicatorCode(String s) { collection[6] = s; }
    public void setReferenceIdentification(String s) { collection[7] = s; }
    public void setFacilityCodeValue(String s) { collection[8] = s; }
    public void setClaimFrequencyTypeCode(String s) { collection[9] = s; }
    public void setPatientStatusCode(String s) { collection[10] = s; }
    public void setDiagnosisRelatedGroupCode(String s) { collection[11] = s; }
    public void setQuantity(String s) { collection[12] = s; }
    public void setPercentageAsDecimal(String s) { collection[13] = s; }
    public void setYesNoConditionOrResponseCode(String s) { collection[14] = s; }
}
