package x12.segment;

import x12.segment.Segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class GS extends Segment {
    public GS(String content, String delimiter) {
        super(content, delimiter);
    }

    protected void setSize() {
        this.size = 0;
    }
    protected void setName() { this.name = "GS"; }
}
