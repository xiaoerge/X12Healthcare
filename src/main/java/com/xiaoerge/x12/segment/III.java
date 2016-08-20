package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 9, name = "III")
public class III extends Segment {
    public III() { super(); }
    public III(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 3)
    public String getCodeListQualifierCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 30)
    public String getIndustryCode() { return collection[2]; }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getCodeCategory() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 264)
    public String getFreeFormMessageText() { return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 15)
    public String getQuantity() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 10)
    public String getCompositeUnitOfMeasure() { return collection[6]; }

    @Definition(position = 7, minLength = 2, maxLength = 2)
    public String getSurfaceLayerPositionCode1() { return collection[7]; }

    @Definition(position = 8, minLength = 2, maxLength = 2)
    public String getSurfaceLayerPositionCode2() { return collection[8]; }

    @Definition(position = 9, minLength = 2, maxLength = 2)
    public String getSurfaceLayerPositionCode3() { return collection[9]; }

    public void setCodeListQualifierCode(String s) { collection[1] = s; }
    public void setIndustryCode(String s) { collection[2] = s; }
    public void setCodeCategory(String s) { collection[3] = s; }
    public void setFreeFormMessageText(String s) { collection[4] = s; }
    public void setQuantity(String s) { collection[5] = s; }
    public void setCompositeUnitOfMeasure(String s) { collection[6] = s; }
    public void setSurfaceLayerPositionCode1(String s) { collection[7] = s; }
    public void setSurfaceLayerPositionCode2(String s) { collection[8] = s; }
    public void setSurfaceLayerPositionCode3(String s) { collection[9] = s; }
}
