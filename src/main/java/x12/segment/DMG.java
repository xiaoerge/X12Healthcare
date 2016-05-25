package x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class DMG extends Segment {
    public DMG(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 0;
    }
    protected void setName() { this.name = "DMG"; }
}
