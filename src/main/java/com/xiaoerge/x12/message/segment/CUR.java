package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 21, name = "CUR")
public class CUR extends Segment {
    public CUR() {super();}
    public CUR(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCode() { return collection[1]; }

    @Definition(position = 2, minLength = 3, maxLength = 3)
    public String getCurrencyCode() { return collection[2]; }

    @Definition(position = 3, minLength = 4, maxLength = 10)
    public String getExchangeRate() { return collection[3]; }

    @Definition(position = 4, minLength = 2, maxLength = 3)
    public String getEntityIdentifierCode2() { return collection[4]; }

    @Definition(position = 5, minLength = 3, maxLength = 3)
    public String getCurrencyCode2() { return collection[5]; }

    @Definition(position = 6, minLength = 3, maxLength = 3)
    public String getCurrencyMarketExchangeCode() { return collection[6]; }

    @Definition(position = 7, minLength = 3, maxLength = 3)
    public String getDateTimeQualifier() { return collection[7]; }

    @Definition(position = 8, minLength = 8, maxLength = 8)
    public String getDate() { return collection[8]; }

    @Definition(position = 9, minLength = 4, maxLength = 8)
    public String getTime() { return collection[9]; }

    @Definition(position = 10, minLength = 3, maxLength = 3)
    public String getDateTimeQualifier2() { return collection[10]; }

    @Definition(position = 11, minLength = 8, maxLength = 8)
    public String getDate2() { return collection[11]; }

    @Definition(position = 12, minLength = 4, maxLength = 8)
    public String getTime2() { return collection[12]; }

    @Definition(position = 13, minLength = 3, maxLength = 3)
    public String getDateTimeQualifier3() { return collection[13]; }

    @Definition(position = 14, minLength = 8, maxLength = 8)
    public String getDate3() { return collection[14]; }

    @Definition(position = 15, minLength = 4, maxLength = 8)
    public String getTime3() { return collection[15]; }

    @Definition(position = 16, minLength = 3, maxLength = 3)
    public String getDateTimeQualifier4() { return collection[16]; }

    @Definition(position = 17, minLength = 8, maxLength = 8)
    public String getDate4() { return collection[17]; }

    @Definition(position = 18, minLength = 4, maxLength = 8)
    public String getTime4() { return collection[18]; }

    @Definition(position = 19, minLength = 3, maxLength = 3)
    public String getDateTimeQualifier5() { return collection[19]; }

    @Definition(position = 20, minLength = 3, maxLength = 8)
    public String getDate5() { return collection[20]; }

    @Definition(position = 21, minLength = 4, maxLength = 8)
    public String getTime5() { return collection[21]; }

    public void getEntityIdentifierCode(String s) { collection[1] = s; }
    public void getCurrencyCode(String s) { collection[2] = s; }
    public void getExchangeRate(String s) { collection[3] = s; }
    public void getEntityIdentifierCode2(String s) { collection[4] = s; }
    public void getCurrencyCode2(String s) { collection[5] = s; }
    public void getCurrencyMarketExchangeCode(String s) { collection[6] = s; }
    public void getDateTimeQualifier(String s) { collection[7] = s; }
    public void getDate(String s) { collection[8] = s; }
    public void getTime(String s) { collection[9] = s; }
    public void getDateTimeQualifier2(String s) { collection[10] = s; }
    public void getDate2(String s) { collection[11] = s; }
    public void getTime2(String s) { collection[12] = s; }
    public void getDateTimeQualifier3(String s) { collection[13] = s; }
    public void getDate3(String s) { collection[14] = s; }
    public void getTime3(String s) { collection[15] = s; }
    public void getDateTimeQualifier4(String s) { collection[16] = s; }
    public void getDate4(String s) { collection[17] = s; }
    public void getTime4(String s) { collection[18] = s; }
    public void getDateTimeQualifier5(String s) { collection[19] = s; }
    public void getDate5(String s) { collection[20] = s; }
    public void getTime5(String s) { collection[21] = s; }
}
