package com.xiaoerge.ediparser.x12.segment;

import com.xiaoerge.ediparser.x12.annotation.Declaration;
import com.xiaoerge.ediparser.x12.annotation.Definition;

/**
 * Created by xiaoerge on 8/13/16.
 */
@Declaration(fieldSize = 4, name = "PER")
public class PER extends Segment {
    public PER() { super(); }
    public PER(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getContactFunctionCode() { return getByDefinition(); }

    @Definition(position = 2, minLength = 1, maxLength = 60)
    public String getName() { return collection[2]; }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getCommunicationNumberQualifier1() { return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 256)
    public String getCommunicationNumber1() { return collection[4]; }

    @Definition(position = 5, minLength = 2, maxLength = 2)
    public String getCommunicationNumberQualifier2() { return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 256)
    public String getCommunicationNumber2() { return collection[6]; }

    @Definition(position = 7, minLength = 2, maxLength = 2)
    public String getCommunicationNumberQualifier3() { return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 256)
    public String getCommunicationNumber3() { return collection[8]; }

    @Definition(position = 9, minLength = 1, maxLength = 20)
    public String getContactInquiryReference() { return collection[9]; }
}
