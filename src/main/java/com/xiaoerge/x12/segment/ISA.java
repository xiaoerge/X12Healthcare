package com.xiaoerge.x12.segment;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class ISA extends Segment
{
    public ISA() {
        super();
    }
    public ISA(String content) {
        super(content);
    }

    protected void setSize() {
        this.size = 16;
    }
    protected void setName() { this.name = "ISA"; }

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

    public void setAuthInfoQualifier(String s) { collection[1] = s;}
    public void setAuthInformation(String s) { collection[2] = s;}
    public void setSecurityInfoQualifier(String s) { collection[3] = s;}
    public void setSecurityInformation(String s) { collection[4] = s;}
    public void setInterchangeIDQualifierSender(String s) { collection[5] = s;}
    public void setInterchangeSenderID(String s) { collection[6] = s;}
    public void setInterchangeIDQualifierReceiver(String s) { collection[7] = s;}
    public void setInterchangeReceiverID(String s) { collection[8] = s;}
    public void setInterchangeDate(String s) { collection[9] = s;}
    public void setInterchangeTime(String s) { collection[10] = s;}
    public void setRepetitionSeparator(String s) { collection[11] = s;}
    public void setInterchangeControlVersionNumber(String s) { collection[12] = s;}
    public void setInterchangeControlNumber(String s) { collection[13] = s;}
    public void setAcknowledgmentRequested(String s) { collection[14] = s;}
    public void setUsageIndicator(String s) { collection[15] = s;}
    public void setComponentElementSeparator(String s) { collection[16] = s;}
}
