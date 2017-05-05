package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 8, name = "GS")
public class GS extends Segment
{
    public GS() {
        super();
    }
    public GS(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getFunctionalIDCode() {return getField(1); }

    @Definition(position = 2, minLength = 2, maxLength = 15)
    public String getApplicationSendersCode() {return getField(2); }

    @Definition(position = 3, minLength = 2, maxLength = 15)
    public String getApplicationReceiversCode() {return getField(3); }

    @Definition(position = 4, minLength = 8, maxLength = 8)
    public String getDate() {return getField(4); }

    @Definition(position = 5, minLength = 4, maxLength = 8)
    public String getTime() {return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 9)
    public String getGroupControlNumber() {return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 2)
    public String getResponsibleAgencyCode() {return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 12)
    public String getVersionReleaseIndustryIDCode() {return getField(8); }

    public void setFunctionalIDCode(String s) { setField(1,s);}
    public void setApplicationSendersCode(String s) { setField(2,s);}
    public void setApplicationReceiversCode(String s) { setField(3,s);}
    public void setDate(String s) { setField(4,s);}
    public void setTime(String s) { setField(5,s);}
    public void setGroupControlNumber(String s) { setField(6,s);}
    public void setResponsibleAgencyCode(String s) { setField(7,s);}
    public void setVersionReleaseIndustryIDCode(String s) { setField(8,s);}
}
