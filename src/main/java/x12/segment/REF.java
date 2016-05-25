package x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class REF extends Segment {
    public REF(String content, String delimiter) {
        super(content, delimiter);
    }

    protected void setSize() {
        this.size = 0;
    }
    protected void setName() { this.name = "REF"; }
}
