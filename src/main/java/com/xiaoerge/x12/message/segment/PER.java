package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 8/13/16.
 */
@Declaration(fieldSize = 9, name = "PER")
public class PER extends Segment {
    public PER() { super(); }
    public PER(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getContactFunctionCode() { return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 60)
    public String getName() { return getField(2); }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getCommunicationNumberQualifier1() { return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 256)
    public String getCommunicationNumber1() { return getField(4); }

    @Definition(position = 5, minLength = 2, maxLength = 2)
    public String getCommunicationNumberQualifier2() { return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 256)
    public String getCommunicationNumber2() { return getField(6); }

    @Definition(position = 7, minLength = 2, maxLength = 2)
    public String getCommunicationNumberQualifier3() { return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 256)
    public String getCommunicationNumber3() { return getField(8); }

    @Definition(position = 9, minLength = 1, maxLength = 20)
    public String getContactInquiryReference() { return getField(9); }

    public void setContactFunctionCode(String s) { setField(1,s); }
    public void setName(String s) { setField(2,s); }
    public void setCommunicationNumberQualifier1(String s) { setField(3,s); }
    public void setCommunicationNumber1(String s) { setField(4,s); }
    public void setCommunicationNumberQualifier2(String s) { setField(5,s); }
    public void setCommunicationNumber2(String s) { setField(6,s); }
    public void setCommunicationNumberQualifier3(String s) { setField(7,s); }
    public void setCommunicationNumber3(String s) { setField(8,s); }
    public void setContactInquiryReference(String s) { setField(9,s); }
}
