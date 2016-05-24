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

    public String getAuthInfoQualifier() {return collection[1];}
    public String getAuthInformation() {return collection[2];}
    public String getSecurityInfoQualifier() {return collection[3];}
    public String getSecurityInformation() {return collection[4];}
    public String getInterchangeIDQualifierSender() {return collection[5];}
    public String getInterchangeSenderID() {return collection[6];}
    public String getInterchangeIDQualifierReceiver() {return collection[7];}
    public String getInterchangeReceiverID() {return collection[8];}
    public String getInterchangeDate() {return collection[9];}
    public String getInterchangeTime() {return collection[10];}
    public String getRepetitionSeparator() {return collection[11];}
    public String getInterchangeControlVersionNumber() {return collection[12];}
    public String getInterchangeControlNumber() {return collection[13];}
    public String getAcknowledgmentRequested() {return collection[14];}
    public String getUsageIndicator() {return collection[15];}
    public String getComponentElementSeparator() {return collection[16];}
}
