package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 2, name = "N3")
public class N3 extends Segment {
    public N3() {super();}
    public N3(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 55)
    public String getAddressInformation1() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 55)
    public String getAddressInformation2() { return getField(2); }

    public void setAddressInformation1(String s) { setField(1,s); }
    public void setAddressInformation2(String s) { setField(2,s); }
}
