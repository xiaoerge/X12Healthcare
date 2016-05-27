package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(size = 8, name = "GS")
public class GS extends Segment
{
    public GS() {
        super();
    }
    public GS(String content) {
        super(content);
    }

    public String getFunctionalIDCode() {return collection[1];}
    public String getApplicationSendersCode() {return collection[2];}
    public String getApplicationReceiversCode() {return collection[3];}
    public String getDate() {return collection[4];}
    public String getTime() {return collection[5];}
    public String getGroupControlNumber() {return collection[6];}
    public String getResponsibleAgencyCode() {return collection[7];}
    public String getVersionReleaseIndustryIDCode() {return collection[8];}

    public void setFunctionalIDCode(String s) { collection[1] = s;}
    public void setApplicationSendersCode(String s) { collection[2] = s;}
    public void setApplicationReceiversCode(String s) { collection[3] = s;}
    public void setDate(String s) { collection[4] = s;}
    public void setTime(String s) { collection[5] = s;}
    public void setGroupControlNumber(String s) { collection[6] = s;}
    public void setResponsibleAgencyCode(String s) { collection[7] = s;}
    public void setVersionReleaseIndustryIDCode(String s) { collection[8] = s;}
}
