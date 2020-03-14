package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "LQ")
public class LQ extends Segment {
    public LQ() {super();}
    public LQ(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 3)
    public String getCodeListQualifierCode() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 30)
    public String getIndustryCode() { return getField(2); }

    public void setCodeListQualifierCode(String s) { setField(1,s); }
    public void setIndustryCode(String s) { setField(2,s); }
}
