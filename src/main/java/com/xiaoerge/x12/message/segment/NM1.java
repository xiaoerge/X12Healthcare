package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

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
    public String getEntityIdentifierCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 1)
    public String getEntityTypeQualifier() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationName() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 35)
    public String getNameFirst() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 25)
    public String getNameMiddle() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 10)
    public String getNamePrefix() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 10)
    public String getNameSuffix() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 2)
    public String getIdentificationCodeQualifier() { return collection[8]; }

    @Definition(position = 9, minLength = 2, maxLength = 80)
    public String getIdentificationCode() { return collection[9]; }

    @Definition(position = 10, minLength = 2, maxLength = 2)
    public String getEntityRelationshipCode() { return collection[10]; }

    @Definition(position = 11, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCodeNotUsed() { return collection[11]; }

    @Definition(position = 12, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationNameNotUsed() { return collection[12]; }

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
