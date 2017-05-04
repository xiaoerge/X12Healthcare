package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 6, name = "N1")
public class N1 extends Segment {
    public N1() { super(); }
    public N1(String content, MessageFormat mf) {
        super(content, mf);
    }
    
    @Definition(position = 1, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 60)
    public String getName() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 2)
    public String getIdentificationCodeQualifier() { return collection[3]; }

    @Definition(position = 4, minLength = 2, maxLength = 80)
    public String getIdentificationCode() { return collection[4]; }

    @Definition(position = 5, minLength = 2, maxLength = 2)
    public String getEntityRelationshipCode() { return collection[5]; }

    @Definition(position = 6, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCode2() { return collection[6]; }

    public void setEntityIdentifierCode(String s) { collection[1] = s; }
    public void setName(String s) { collection[2] = s; }
    public void setIdentificationCodeQualifier(String s) { collection[3] = s; }
    public void setIdentificationCode(String s) { collection[4] = s; }
    public void setEntityRelationshipCode(String s) { collection[5] = s; }
    public void setEntityIdentifierCode2(String s) { collection[6] = s; }
}
