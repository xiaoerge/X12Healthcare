package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 7, name = "MPI")
public class MPI extends Segment {
    public MPI() {
        super();
    }
    public MPI(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 1)
    public String getInformationStatusCode() { return collection[1]; }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getEmploymentStatusCode() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 1)
    public String getGovernmentServiceAffiliationCode() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 80)
    public String getDescription() { return collection[4]; }

    @Definition(position = 5, minLength = 2, maxLength = 2)
    public String getMilitaryServiceRankCode() { return collection[5]; }

    @Definition(position = 6, minLength = 2, maxLength = 3)
    public String getDateTimePeriodFormatQualifier() { return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 35)
    public String getDateTimePeriod() { return collection[7]; }

    public void setInformationStatusCode(String s) { collection[1] = s; }
    public void setEmploymentStatusCode(String s) { collection[2] = s; }
    public void setGovernmentServiceAffiliationCode(String s) { collection[3] = s; }
    public void setDescription(String s) { collection[4] = s; }
    public void setMilitaryServiceRankCode(String s) { collection[5] = s; }
    public void setDateTimePeriodFormatQualifier(String s) { collection[6] = s; }
    public void setDateTimePeriod(String s) { collection[7] = s; }
}
