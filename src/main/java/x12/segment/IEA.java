package x12.segment;

import x12.segment.Segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class IEA extends Segment {
    public IEA(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 0;
    }
    protected void setName() { this.name = "IEA"; }
}
