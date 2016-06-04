package com.xiaoerge.healthcare.x12.segment;

import com.xiaoerge.healthcare.x12.annotation.Declaration;
import com.xiaoerge.healthcare.x12.annotation.Definition;
import com.xiaoerge.healthcare.x12.enumeration.Required;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 16, name = "ISA")
public class ISA extends Segment
{
    public ISA() {
        super();
    }
    public ISA(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2, codeValues = {"00", "03"})
    public String getAuthInfoQualifier() {return collection[1];}

    @Definition(position = 2, minLength = 10, maxLength = 10)
    public String getAuthInformation() {return collection[2];}

    @Definition(position = 3, minLength = 2, maxLength = 2, codeValues = {"00", "01"})
    public String getSecurityInfoQualifier() {return collection[3];}

    @Definition(position = 4, minLength = 10, maxLength = 10)
    public String getSecurityInformation() {return collection[4];}

    @Definition(position = 5, minLength = 2, maxLength = 2, codeValues = {"01", "14", "20", "27", "28", "29", "30", "33", "ZZ"})
    public String getInterchangeIDQualifierSender() {return collection[5];}

    @Definition(position = 6, minLength = 15, maxLength = 15)
    public String getInterchangeSenderID() {return collection[6];}

    @Definition(position = 7, minLength = 2, maxLength = 2, codeValues = {"01", "14", "20", "27", "28", "29", "30", "33", "ZZ"})
    public String getInterchangeIDQualifierReceiver() {return collection[7];}

    @Definition(position = 8, minLength = 15, maxLength = 15)
    public String getInterchangeReceiverID() {return collection[8];}

    @Definition(position = 9, minLength = 6, maxLength = 6)
    public String getInterchangeDate() {return collection[9];}

    @Definition(position = 10, minLength = 4, maxLength = 4)
    public String getInterchangeTime() {return collection[10];}

    @Definition(position = 11, minLength = 1, maxLength = 1, codeValues = {"^"})
    public String getRepetitionSeparator() {return collection[11];}

    @Definition(position = 12, minLength = 5, maxLength = 5)
    public String getInterchangeControlVersionNumber() {return collection[12];}

    @Definition(position = 13, minLength = 9, maxLength = 9)
    public String getInterchangeControlNumber() {return collection[13];}

    @Definition(position = 14, minLength = 1, maxLength = 1, codeValues = {"0", "1"})
    public String getAcknowledgmentRequested() {return collection[14];}

    @Definition(position = 15, minLength = 1, maxLength = 1, codeValues = {"P", "T"})
    public String getUsageIndicator() {return collection[15];}

    @Definition(position = 16, minLength = 1, maxLength = 1)
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
