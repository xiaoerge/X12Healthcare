package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 8/13/16.
 */
@Declaration(fieldSize = 4, name = "AAA")
public class AAA extends Segment {
    public AAA() { super(); }
    public AAA(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 1)
    public String getYesNoConditionOrResponseCode() { return collection[1]; }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getAgencyQualifierCode() { return collection[2]; }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getRejectReasonCode() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 1)
    public String getFollowupActionCode() { return collection[4]; }

    public void setYesNoConditionOrResponseCode(String s) { collection[1] = s; }
    public void setAgencyQualifierCode(String s) { collection[2] = s; }
    public void setRejectReasonCode(String s) { collection[3] = s; }
    public void setFollowupActionCode(String s) { collection[4] = s; }
}
