package com.xiaoerge.healthcare.x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class N4 extends Segment {
    public N4(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 0;
    }
    protected void setName() { this.name = "N4"; }
}
