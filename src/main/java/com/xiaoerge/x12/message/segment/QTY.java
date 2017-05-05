package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 4, name = "QTY")
public class QTY extends Segment {
    public QTY() {super();}
    public QTY(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getQuantityQualifier() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 15)
    public String getQuantity() { return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 100)
    public String getCOMPOSITEUNITOFMEASURE() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 30)
    public String getFreeFormInformation() { return getField(4); }

    public void setQuantityQualifier(String s) { setField(1,s); }
    public void setQuantity(String s) { setField(2,s); }
    public void setCOMPOSITEUNITOFMEASURE(String s) { setField(3,s); }
    public void setFreeFormInformation(String s) { setField(4,s); }
}
