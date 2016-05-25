package x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class N4 extends Segment {
    public N4(String content, String delimiter) {
        super(content, delimiter);
    }

    protected void setSize() {
        this.size = 0;
    }
    protected void setName() { this.name = "N4"; }
}
