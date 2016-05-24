package x12.segment;

import x12.segment.Segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class GE extends Segment {
    public GE(String content, String delimiter) {
        super(content, delimiter);
    }

    protected void setSize() {
        this.size = 0;
    }
}
