package x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class N3 extends Segment {
    public N3(String content, String delimiter) {
        super(content, delimiter);
    }

    protected void setSize() {
        this.size = 0;
    }
}
