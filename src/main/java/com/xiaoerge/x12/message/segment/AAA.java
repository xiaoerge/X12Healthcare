package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 8/13/16.
 */
@Declaration(fieldSize = 4, name = "AAA")
public class AAA extends Segment {
    public AAA() { super(); }
    public AAA(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode() { return getField(1); }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getAgencyQualifierCode() { return getField(2); }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getRejectReasonCode() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 1)
    public String getFollowupActionCode() { return getField(4); }

    public void setYesNoConditionOrResponseCode(String s) { setField(1,s); }
    public void setAgencyQualifierCode(String s) { setField(2,s); }
    public void setRejectReasonCode(String s) { setField(3,s); }
    public void setFollowupActionCode(String s) { setField(4,s); }
}
