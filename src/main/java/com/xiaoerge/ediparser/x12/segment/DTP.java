package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Definition;
import com.xiaoerge.ediparser.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 3, name = "DTP")
public class DTP extends Segment {
    public DTP() { super(); }
    public DTP(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 3, maxLength = 3)
    public String getDateTimeQualifier() { return getByDefinition(); }

    @Definition(position = 2, minLength = 2, maxLength = 3)
    public String getDateTimePeriodFormatQualifier() { return getByDefinition(); }

    @Definition(position = 3, minLength = 1, maxLength = 35)
    public String getDateTimePeriod() { return getByDefinition(); }

    public void setDateTimeQualifier(String s) { collection[1] = s; }
    public void setDateTimePeriodFormatQualifier(String s) { collection[2] = s; }
    public void setDateTimePeriod(String s) { collection[3] = s; }
}
