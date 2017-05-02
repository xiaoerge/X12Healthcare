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
    public String getEligibilityOrBenefitInformationCode() { return collection[1]; }

    @Definition(position = 2, minLength = 3, maxLength = 3)
    public String getCoverageLevelCode() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 2)
    public String getServiceTypeCode() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 3)
    public String getInsuranceTypeCode() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 50)
    public String getPlanCoverageDescription() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 2)
    public String getTimePeriodQualifier() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 10)
    public String getPercentageAsDecimal() { return collection[8]; }

    @Definition(position = 9, minLength = 2, maxLength = 2)
    public String getQuantityQualifier() { return collection[9]; }

    @Definition(position = 10, minLength = 1, maxLength = 15)
    public String getQuantity() { return collection[10]; }

    @Definition(position = 11, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode2() { return collection[12]; }

    @Definition(position = 13, minLength = 1, maxLength = 186)
    public String getCompositeMedicalProcedureIdentifier() { return collection[13]; }

    @Definition(position = 14, minLength = 1, maxLength = 8)
    public String getCompositeDiagnosisCodePointer() { return collection[14]; }

    public void setEligibilityOrBenefitInformationCode(String s) {collection[1] = s;}
    public void setCoverageLevelCode(String s) {collection[2] = s;}
    public void setServiceTypeCode(String s) {collection[3] = s;}
    public void setInsuranceTypeCode(String s) {collection[4] = s;}
    public void setPlanCoverageDescription(String s) {collection[5] = s;}
    public void setTimePeriodQualifier(String s) {collection[6] = s;}
    public void setMonetaryAmount(String s) {collection[7] = s;}
    public void setPercentageAsDecimal(String s) {collection[8] = s;}
    public void setQuantityQualifier(String s) {collection[9] = s;}
    public void setQuantity(String s) {collection[10] = s;}
    public void setYesNoConditionOrResponseCode(String s) {collection[11] = s;}
    public void setYesNoConditionOrResponseCode2(String s) {collection[12] = s;}
    public void setCompositeMedicalProcedureIdentifier(String s) {collection[13] = s;}
    public void setCompositeDiagnosisCodePointer(String s) {collection[14] = s;}
}
