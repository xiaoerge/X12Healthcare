package x12.segment;

import x12.segment.Segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class GE extends Segment {
    public GE(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 0;
    }
    protected void setName() { this.name = "GE"; }
}
