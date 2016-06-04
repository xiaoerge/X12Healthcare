package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(requiredSize = 1, fieldSize = 2, name = "N3")
public class N3 extends Segment {
    public N3() {super();}
    public N3(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 1, maxLength = 55)
    public String getAddressInformation() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 55)
    public String getAddressInformation2() { return collection[2]; }
}
