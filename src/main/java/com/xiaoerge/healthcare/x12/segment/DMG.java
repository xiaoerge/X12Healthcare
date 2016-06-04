package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 11, name = "DMG")
public class DMG extends Segment {
    public DMG() { super(); }
    public DMG(String content) {
        super(content);
    }
}
