package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 8, name = "GS")
public class GS extends Segment
{
    public GS() {
        super();
    }
    public GS(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getFunctionalIDCode() {return getByPosition(); }

    @Definition(position = 2, minLength = 2, maxLength = 15)
    public String getApplicationSendersCode() {return getByPosition(); }

    @Definition(position = 3, minLength = 2, maxLength = 15)
    public String getApplicationReceiversCode() {return getByPosition(); }

    @Definition(position = 4, minLength = 8, maxLength = 8)
    public String getDate() {return getByPosition(); }

    @Definition(position = 5, minLength = 4, maxLength = 8)
    public String getTime() {return getByPosition(); }

    @Definition(position = 6, minLength = 1, maxLength = 9)
    public String getGroupControlNumber() {return getByPosition(); }

    @Definition(position = 7, minLength = 1, maxLength = 2)
    public String getResponsibleAgencyCode() {return getByPosition(); }

    @Definition(position = 8, minLength = 1, maxLength = 12)
    public String getVersionReleaseIndustryIDCode() {return getByPosition(); }

    public void setFunctionalIDCode(String s) { collection[1] = s;}
    public void setApplicationSendersCode(String s) { collection[2] = s;}
    public void setApplicationReceiversCode(String s) { collection[3] = s;}
    public void setDate(String s) { collection[4] = s;}
    public void setTime(String s) { collection[5] = s;}
    public void setGroupControlNumber(String s) { collection[6] = s;}
    public void setResponsibleAgencyCode(String s) { collection[7] = s;}
    public void setVersionReleaseIndustryIDCode(String s) { collection[8] = s;}
}
