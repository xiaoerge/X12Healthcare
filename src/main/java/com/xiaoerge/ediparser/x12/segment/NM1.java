package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Declaration;
import com.xiaoerge.ediparser.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 12, name = "NM1")
public class NM1 extends Segment {
    public NM1() {
        super();
    }
    public NM1(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCode() { return getByDefinition(); }

    @Definition(position = 2, minLength = 1, maxLength = 1)
    public String getEntityTypeQualifier() { return getByDefinition(); }

    @Definition(position = 3, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationName() { return getByDefinition(); }

    @Definition(position = 4, minLength = 1, maxLength = 35)
    public String getNameFirst() { return getByDefinition(); }

    @Definition(position = 5, minLength = 1, maxLength = 25)
    public String getNameMiddle() { return getByDefinition(); }

    @Definition(position = 6, minLength = 1, maxLength = 10)
    public String getNamePrefix() { return getByDefinition(); }

    @Definition(position = 7, minLength = 1, maxLength = 10)
    public String getNameSuffix() { return getByDefinition(); }

    @Definition(position = 8, minLength = 1, maxLength = 2)
    public String getIdentificationCodeQualifier() { return getByDefinition(); }

    @Definition(position = 9, minLength = 2, maxLength = 80)
    public String getIdentificationCode() { return getByDefinition(); }

    @Definition(position = 10, minLength = 2, maxLength = 2)
    public String getEntityRelationshipCode() { return getByDefinition(); }

    @Definition(position = 11, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCodeNotUsed() { return getByDefinition(); }

    @Definition(position = 12, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationNameNotUsed() { return getByDefinition(); }

    public void setEntityIdentifierCode(String s) { collection[1] = s; }
    public void setEntityTypeQualifier(String s) { collection[2] = s; }
    public void setNameLastOrOrganizationName(String s) { collection[3] = s; }
    public void setNameFirst(String s) { collection[4] = s; }
    public void setNameMiddle(String s) { collection[5] = s; }
    public void setNamePrefix(String s) { collection[6] = s; }
    public void setNameSuffix(String s) { collection[7] = s; }
    public void setIdentificationCodeQualifier(String s) { collection[8] = s; }
    public void setIdentificationCode(String s) { collection[9] = s; }
    public void setEntityRelationshipCode(String s) { collection[10] = s; }
    public void setEntityIdentifierCodeNotUsed(String s) { collection[11] = s; }
    public void setNameLastOrOrganizationNameNotUsed(String s) { collection[12] = s; }
}
