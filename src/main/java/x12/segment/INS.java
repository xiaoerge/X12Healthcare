package x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class INS extends Segment {
    public INS(String content, String delimiter) {
        super(content, delimiter);
    }

    protected void setSize() {
        this.size = 0;
    }
}
