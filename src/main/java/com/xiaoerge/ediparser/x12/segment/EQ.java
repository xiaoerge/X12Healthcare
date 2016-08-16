package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Definition;
import com.xiaoerge.ediparser.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 5, name = "EQ")
public class EQ extends Segment {
    public EQ() { super(); }
    public EQ(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getServiceTypeCode() { return getByDefinition(); }

    @Definition(position = 2, minLength = 2, maxLength = 176)
    public String getCompositeMedicalProcedureIdentifier() { return getByDefinition(); }

    @Definition(position = 3, minLength = 3, maxLength = 3)
    public String getCoverageLevelCode() { return getByDefinition(); }

    @Definition(position = 4, minLength = 1, maxLength = 3)
    public String getInsuranceTypeCode() { return getByDefinition(); }

    @Definition(position = 5, minLength = 1, maxLength = 8)
    public String getCompositeDiagnosisCodePointer() { return getByDefinition(); }

    public void setServiceTypeCode(String s) {collection[1] = s;}
    public void setCompositeMedicalProcedureIdentifier(String s) {collection[2] = s;}
    public void setCoverageLevelCode(String s) {collection[3] = s;}
    public void setInsuranceTypeCode(String s) {collection[4] = s;}
    public void setCompositeDiagnosisCodePointer(String s) {collection[5] = s;}
}
