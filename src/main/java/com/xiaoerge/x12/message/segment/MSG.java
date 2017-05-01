package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 3, name = "MSG")
public class MSG extends Segment {
    public MSG() {
        super();
    }
    public MSG(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 264)
    public String getFreeFormMessageText() { return collection[1]; }

    @Definition(position = 2, minLength = 2, maxLength = 2)
    public String getPrinterCarriageControlCode() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 9)
    public String getNumber() { return collection[3]; }

    public void setFreeFormMessageText(String s) { collection[1] = s; }
    public void setPrinterCarriageControlCode(String s) { collection[2] = s; }
    public void setNumber(String s) { collection[3] = s; }
}
