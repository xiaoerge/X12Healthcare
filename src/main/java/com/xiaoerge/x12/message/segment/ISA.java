package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 16, name = "ISA")
public class ISA extends Segment
{
    public ISA() {
        super();
    }
    public ISA(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getAuthInfoQualifier() {return getField(1); }

    @Definition(position = 2, minLength = 10, maxLength = 10)
    public String getAuthInformation() {return getField(2); }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getSecurityInfoQualifier() {return getField(3); }

    @Definition(position = 4, minLength = 10, maxLength = 10)
    public String getSecurityInformation() {return getField(4); }

    @Definition(position = 5, minLength = 2, maxLength = 2)
    public String getInterchangeIDQualifierSender() {return getField(5); }

    @Definition(position = 6, minLength = 15, maxLength = 15)
    public String getInterchangeSenderID() {return getField(6); }

    @Definition(position = 7, minLength = 2, maxLength = 2)
    public String getInterchangeIDQualifierReceiver() {return getField(7); }

    @Definition(position = 8, minLength = 15, maxLength = 15)
    public String getInterchangeReceiverID() {return getField(8); }

    @Definition(position = 9, minLength = 6, maxLength = 6)
    public String getInterchangeDate() {return getField(9); }

    @Definition(position = 10, minLength = 4, maxLength = 4)
    public String getInterchangeTime() {return getField(10); }

    @Definition(position = 11, minLength = 1, maxLength = 1)
    public String getRepetitionSeparator() {return getField(11); }

    @Definition(position = 12, minLength = 5, maxLength = 5)
    public String getInterchangeControlVersionNumber() {return getField(12); }

    @Definition(position = 13, minLength = 9, maxLength = 9)
    public String getInterchangeControlNumber() {return getField(13); }

    @Definition(position = 14, minLength = 1, maxLength = 1)
    public String getAcknowledgmentRequested() {return getField(14); }

    @Definition(position = 15, minLength = 1, maxLength = 1)
    public String getUsageIndicator() {return getField(15); }

    @Definition(position = 16, minLength = 1, maxLength = 1)
    public String getComponentElementSeparator() {return getField(16); }

    public void setAuthInfoQualifier(String s) { setField(1,s);}
    public void setAuthInformation(String s) { setField(2,s);}
    public void setSecurityInfoQualifier(String s) { setField(3,s);}
    public void setSecurityInformation(String s) { setField(4,s);}
    public void setInterchangeIDQualifierSender(String s) { setField(5,s);}
    public void setInterchangeSenderID(String s) { setField(6,s);}
    public void setInterchangeIDQualifierReceiver(String s) { setField(7,s);}
    public void setInterchangeReceiverID(String s) { setField(8,s);}
    public void setInterchangeDate(String s) { setField(9,s);}
    public void setInterchangeTime(String s) { setField(10,s);}
    public void setRepetitionSeparator(String s) { setField(11,s);}
    public void setInterchangeControlVersionNumber(String s) { setField(12,s);}
    public void setInterchangeControlNumber(String s) { setField(13,s);}
    public void setAcknowledgmentRequested(String s) { setField(14,s);}
    public void setUsageIndicator(String s) { setField(15,s);}
    public void setComponentElementSeparator(String s) { setField(16,s);}
}
