package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "LQ")
public class LQ extends Segment {
    public LQ() {super();}
    public LQ(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 3)
    public String getCodeListQualifierCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 30)
    public String getIndustryCode() { return collection[2]; }

    public void setCodeListQualifierCode(String s) { collection[1] = s; }
    public void setIndustryCode(String s) { collection[2] = s; }
}
