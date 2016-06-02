package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;
import com.xiaoerge.healthcare.x12.enumeration.Required;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(requiredSize = 5, fieldSize = 12, name = "NM1")
public class NM1 extends Segment {
    public NM1() {
        super();
    }
    public NM1(String content) {
        super(content);
    }

    @Definition(required = Required.REQUIRED, position = 1, minLength = 2, maxLength = 3, codeValues = {"1P", "2B", "36", "80", "FA", "GP", "P5", "PR"})
    public String getEntityIdentifierCode() { return collection[1]; }

    @Definition(required = Required.REQUIRED, position = 2, minLength = 1, maxLength = 1, codeValues = {"1", "2"})
    public String getEntityTypeQualifier() { return collection[2]; }

    @Definition(required = Required.REQUIRED, position = 3, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationName() { return collection[3]; }

    @Definition(required = Required.SITUATIONAL, position = 4, minLength = 1, maxLength = 35)
    public String getNameFirst() { return collection[4]; }

    @Definition(required = Required.SITUATIONAL, position = 5, minLength = 1, maxLength = 25)
    public String getNameMiddle() { return collection[5]; }

    @Definition(required = Required.NOTUSED, position = 6, minLength = 1, maxLength = 10)
    public String getPrefix() { return collection[6]; }

    @Definition(required = Required.SITUATIONAL, position = 7, minLength = 1, maxLength = 10)
    public String getNameSuffix() { return collection[7]; }

    @Definition(required = Required.REQUIRED, position = 8, minLength = 1, maxLength = 2, codeValues = {"24", "34", "FI", "PI", "PP", "SV"})
    public String getIdentificationCodeQualifier() { return collection[8]; }

    @Definition(required = Required.REQUIRED, position = 9, minLength = 2, maxLength = 80)
    public String getIdentificationCode() { return collection[9]; }

    @Definition(required = Required.NOTUSED, position = 10, minLength = 2, maxLength = 2)
    public String getEntityRelationshipCode() { return collection[10]; }

    @Definition(required = Required.NOTUSED, position = 11, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCodeNotUsed() { return collection[11]; }

    @Definition(required = Required.NOTUSED, position = 12, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationNameNotUsed() { return collection[12]; }

    public void setEntityIdentifierCode(String s) { collection[1] = s; }
    public void setEntityTypeQualifier(String s) { collection[2] = s; }
    public void setNameLastOrOrganizationName(String s) { collection[3] = s; }
    public void setNameFirst(String s) { collection[4] = s; }
    public void setNameMiddle(String s) { collection[5] = s; }
    public void setPrefix(String s) { collection[6] = s; }
    public void setNameSuffix(String s) { collection[7] = s; }
    public void setIdentificationCodeQualifier(String s) { collection[8] = s; }
    public void setIdentificationCode(String s) { collection[9] = s; }
    public void setEntityRelationshipCode(String s) { collection[10] = s; }
    public void setEntityIdentifierCodeNotUsed(String s) { collection[11] = s; }
    public void setNameLastOrOrganizationNameNotUsed(String s) { collection[12] = s; }
}
