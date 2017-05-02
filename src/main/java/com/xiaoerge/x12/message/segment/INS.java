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
    public String getYesNoConditionOrResponseCode() { return collection[1]; }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getIndividualRelationshipCode() { return collection[2]; }

    @Definition(position = 3, minLength = 3, maxLength = 3)
    public String getMaintenanceTypeCode() { return collection[3]; }

    @Definition(position = 4, minLength = 2, maxLength = 3)
    public String getMaintenanceReasonCode() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 1)
    public String getBenefitStatusCode() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 10)
    public String getMedicareStatusCode() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 2)
    public String getConsolidatedOmnibusBudgetReconciliationActQualifying() { return collection[7]; }

    @Definition(position = 8, minLength = 2, maxLength = 2)
    public String getEmploymentStatusCode() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 1)
    public String getStudentStatusCode() { return collection[9]; }

    @Definition(position = 10, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode2() { return collection[10]; }

    @Definition(position = 11, minLength = 2, maxLength = 3)
    public String getDateTimePeriodFormatQualifier() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 35)
    public String getDateTimePeriod() { return collection[12]; }

    @Definition(position = 13, minLength = 1, maxLength = 1)
    public String getConfidentialityCode() { return collection[13]; }

    @Definition(position = 14, minLength = 2, maxLength = 30)
    public String getCityName() { return collection[14]; }

    @Definition(position = 15, minLength = 2, maxLength = 2)
    public String getStateOrProvinceCode() { return collection[15]; }

    @Definition(position = 16, minLength = 2, maxLength = 3)
    public String getCountryCode() { return collection[16]; }

    @Definition(position = 17, minLength = 1, maxLength = 9)
    public String getNumber() { return collection[17]; }

    public void setYesNoConditionOrResponseCode(String s) { collection[1] = s; }
    public void setIndividualRelationshipCode(String s) { collection[2] = s; }
    public void setMaintenanceTypeCode(String s) { collection[3] = s; }
    public void setMaintenanceReasonCode(String s) { collection[4] = s; }
    public void setBenefitStatusCode(String s) { collection[5] = s; }
    public void setMedicareStatusCode(String s) { collection[6] = s; }
    public void setConsolidatedOmnibusBudgetReconciliationActQualifying(String s) { collection[7] = s; }
    public void setEmploymentStatusCode(String s) { collection[8] = s; }
    public void setStudentStatusCode(String s) { collection[9] = s; }
    public void setYesNoConditionOrResponseCode2(String s) { collection[10] = s; }
    public void setDateTimePeriodFormatQualifier(String s) { collection[11] = s; }
    public void setDateTimePeriod(String s) { collection[12] = s; }
    public void setConfidentialityCode(String s) { collection[13] = s; }
    public void setCityName(String s) { collection[14] = s; }
    public void setStateOrProvinceCode(String s) { collection[15] = s; }
    public void setCountryCode(String s) { collection[16] = s; }
    public void setNumber(String s) { collection[17] = s; }
}
