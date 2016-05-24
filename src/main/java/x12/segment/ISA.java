package x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class ISA extends Segment
{
    public ISA(String content, String delimiter) {
        super(content, delimiter);
    }

    protected void setSize() {
        this.size = 16;
    }

    public String getAuthorInfoQualifier() {
        return collection[1];
    }
    public String getAuthorInformation() { return collection[2]; }
    public String getSecurityInfoQualifier() { return collection[3]; }
    public String getSecurityInformation() { return collection[4]; }
}
