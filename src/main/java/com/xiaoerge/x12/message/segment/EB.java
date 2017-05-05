package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 14, name = "EB")
public class EB extends Segment {
    public EB() { super(); }
    public EB(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getEligibilityOrBenefitInformationCode() { return getField(1); }

    @Definition(position = 2, minLength = 3, maxLength = 3)
    public String getCoverageLevelCode() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 2)
    public String getServiceTypeCode() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 3)
    public String getInsuranceTypeCode() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 50)
    public String getPlanCoverageDescription() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 2)
    public String getTimePeriodQualifier() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 10)
    public String getPercentageAsDecimal() { return getField(8); }

    @Definition(position = 9, minLength = 2, maxLength = 2)
    public String getQuantityQualifier() { return getField(9); }

    @Definition(position = 10, minLength = 1, maxLength = 15)
    public String getQuantity() { return getField(10); }

    @Definition(position = 11, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode() { return getField(11); }

    @Definition(position = 12, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode2() { return getField(12); }

    @Definition(position = 13, minLength = 1, maxLength = 186)
    public String getCompositeMedicalProcedureIdentifier() { return getField(13); }

    @Definition(position = 14, minLength = 1, maxLength = 8)
    public String getCompositeDiagnosisCodePointer() { return getField(14); }

    public void setEligibilityOrBenefitInformationCode(String s) {setField(1,s);}
    public void setCoverageLevelCode(String s) {setField(2,s);}
    public void setServiceTypeCode(String s) {setField(3,s);}
    public void setInsuranceTypeCode(String s) {setField(4,s);}
    public void setPlanCoverageDescription(String s) {setField(5,s);}
    public void setTimePeriodQualifier(String s) {setField(6,s);}
    public void setMonetaryAmount(String s) {setField(7,s);}
    public void setPercentageAsDecimal(String s) {setField(8,s);}
    public void setQuantityQualifier(String s) {setField(9,s);}
    public void setQuantity(String s) {setField(10,s);}
    public void setYesNoConditionOrResponseCode(String s) {setField(11,s);}
    public void setYesNoConditionOrResponseCode2(String s) {setField(12,s);}
    public void setCompositeMedicalProcedureIdentifier(String s) {setField(13,s);}
    public void setCompositeDiagnosisCodePointer(String s) {setField(14,s);}
}
