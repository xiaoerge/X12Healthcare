package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 17, name = "INS")
public class INS extends Segment {
    public INS() { super(); }
    public INS(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode() { return getField(1); }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getIndividualRelationshipCode() { return getField(2); }

    @Definition(position = 3, minLength = 3, maxLength = 3)
    public String getMaintenanceTypeCode() { return getField(3); }

    @Definition(position = 4, minLength = 2, maxLength = 3)
    public String getMaintenanceReasonCode() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 1)
    public String getBenefitStatusCode() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 10)
    public String getMedicareStatusCode() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 2)
    public String getConsolidatedOmnibusBudgetReconciliationActQualifying() { return getField(7); }

    @Definition(position = 8, minLength = 2, maxLength = 2)
    public String getEmploymentStatusCode() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 1)
    public String getStudentStatusCode() { return getField(9); }

    @Definition(position = 10, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode2() { return getField(10); }

    @Definition(position = 11, minLength = 2, maxLength = 3)
    public String getDateTimePeriodFormatQualifier() { return getField(11); }

    @Definition(position = 12, minLength = 1, maxLength = 35)
    public String getDateTimePeriod() { return getField(12); }

    @Definition(position = 13, minLength = 1, maxLength = 1)
    public String getConfidentialityCode() { return getField(13); }

    @Definition(position = 14, minLength = 2, maxLength = 30)
    public String getCityName() { return getField(14); }

    @Definition(position = 15, minLength = 2, maxLength = 2)
    public String getStateOrProvinceCode() { return getField(15); }

    @Definition(position = 16, minLength = 2, maxLength = 3)
    public String getCountryCode() { return getField(16); }

    @Definition(position = 17, minLength = 1, maxLength = 9)
    public String getNumber() { return getField(17); }

    public void setYesNoConditionOrResponseCode(String s) { setField(1,s); }
    public void setIndividualRelationshipCode(String s) { setField(2,s); }
    public void setMaintenanceTypeCode(String s) { setField(3,s); }
    public void setMaintenanceReasonCode(String s) { setField(4,s); }
    public void setBenefitStatusCode(String s) { setField(5,s); }
    public void setMedicareStatusCode(String s) { setField(6,s); }
    public void setConsolidatedOmnibusBudgetReconciliationActQualifying(String s) { setField(7,s); }
    public void setEmploymentStatusCode(String s) { setField(8,s); }
    public void setStudentStatusCode(String s) { setField(9,s); }
    public void setYesNoConditionOrResponseCode2(String s) { setField(10,s); }
    public void setDateTimePeriodFormatQualifier(String s) { setField(11,s); }
    public void setDateTimePeriod(String s) { setField(12,s); }
    public void setConfidentialityCode(String s) { setField(13,s); }
    public void setCityName(String s) { setField(14,s); }
    public void setStateOrProvinceCode(String s) { setField(15,s); }
    public void setCountryCode(String s) { setField(16,s); }
    public void setNumber(String s) { setField(17,s); }
}
