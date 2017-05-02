package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "QTY")
public class QTY extends Segment {
    public QTY() {super();}
    public QTY(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getQuantityQualifier() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 15)
    public String getQuantity() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 100)
    public String getCOMPOSITEUNITOFMEASURE() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 30)
    public String getFreeFormInformation() { return collection[4]; }

    public void setQuantityQualifier(String s) { collection[1] = s; }
    public void setQuantity(String s) { collection[2] = s; }
    public void setCOMPOSITEUNITOFMEASURE(String s) { collection[3] = s; }
    public void setFreeFormInformation(String s) { collection[4] = s; }
}
