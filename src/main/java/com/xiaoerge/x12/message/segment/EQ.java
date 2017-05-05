package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 5, name = "EQ")
public class EQ extends Segment {
    public EQ() { super(); }
    public EQ(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getServiceTypeCode() { return getField(1); }

    @Definition(position = 2, minLength = 2, maxLength = 176)
    public String getCompositeMedicalProcedureIdentifier() { return getField(2); }

    @Definition(position = 3, minLength = 3, maxLength = 3)
    public String getCoverageLevelCode() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 3)
    public String getInsuranceTypeCode() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 8)
    public String getCompositeDiagnosisCodePointer() { return getField(5); }

    public void setServiceTypeCode(String s) {setField(1,s);}
    public void setCompositeMedicalProcedureIdentifier(String s) {setField(2,s);}
    public void setCoverageLevelCode(String s) {setField(3,s);}
    public void setInsuranceTypeCode(String s) {setField(4,s);}
    public void setCompositeDiagnosisCodePointer(String s) {setField(5,s);}
}
