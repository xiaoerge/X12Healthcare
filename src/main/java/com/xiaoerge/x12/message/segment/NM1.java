package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 12, name = "NM1")
public class NM1 extends Segment {
    public NM1() {
        super();
    }
    public NM1(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCode() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 1)
    public String getEntityTypeQualifier() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationName() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 35)
    public String getNameFirst() { return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 25)
    public String getNameMiddle() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 10)
    public String getNamePrefix() { return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 10)
    public String getNameSuffix() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 2)
    public String getIdentificationCodeQualifier() { return getField(8); }

    @Definition(position = 9, minLength = 2, maxLength = 80)
    public String getIdentificationCode() { return getField(9); }

    @Definition(position = 10, minLength = 2, maxLength = 2)
    public String getEntityRelationshipCode() { return getField(10); }

    @Definition(position = 11, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCodeNotUsed() { return getField(11); }

    @Definition(position = 12, minLength = 1, maxLength = 60)
    public String getNameLastOrOrganizationNameNotUsed() { return getField(12); }

    public void setEntityIdentifierCode(String s) { setField(1,s); }
    public void setEntityTypeQualifier(String s) { setField(2,s); }
    public void setNameLastOrOrganizationName(String s) { setField(3,s); }
    public void setNameFirst(String s) { setField(4,s); }
    public void setNameMiddle(String s) { setField(5,s); }
    public void setNamePrefix(String s) { setField(6,s); }
    public void setNameSuffix(String s) { setField(7,s); }
    public void setIdentificationCodeQualifier(String s) { setField(8,s); }
    public void setIdentificationCode(String s) { setField(9,s); }
    public void setEntityRelationshipCode(String s) { setField(10,s); }
    public void setEntityIdentifierCodeNotUsed(String s) { setField(11,s); }
    public void setNameLastOrOrganizationNameNotUsed(String s) { setField(12,s); }
}
