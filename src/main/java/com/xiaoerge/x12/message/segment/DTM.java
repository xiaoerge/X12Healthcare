package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 11, name = "DTM")
public class DTM extends Segment {
    public DTM() { super(); }
    public DTM(String content) {
        super(content);
    }
    
    @Definition(position = 1, minLength = 3, maxLength = 3)
    public String getDateTimeQualifier() { return collection[1]; }

    @Definition(position = 2, minLength = 8, maxLength = 8)
    public String getDate() { return collection[2]; }

    @Definition(position = 3, minLength = 4, maxLength = 8)
    public String getTime() { return collection[3]; }

    @Definition(position = 4, minLength = 2, maxLength = 2)
    public String getTimeCode() { return collection[4]; }

    @Definition(position = 5, minLength = 2, maxLength = 3)
    public String getDateTimePeriodFormatQualifier() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 35)
    public String getDateTimePeriod() { return collection[6]; }

    public void setDateTimeQualifier(String s) { collection[1] = s; }
    public void setDate(String s) { collection[2] = s; }
    public void setTime(String s) { collection[3] = s; }
    public void setTimeCode(String s) { collection[4] = s; }
    public void setDateTimePeriodFormatQualifier(String s) { collection[5] = s; }
    public void setDateTimePeriod(String s) { collection[6] = s; }
}
