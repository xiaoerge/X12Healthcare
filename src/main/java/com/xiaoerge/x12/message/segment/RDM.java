package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 5, name = "RDM")
public class RDM extends Segment {
    public RDM() { super(); }
    public RDM(String content, MessageFormat mf) {
        super(content, mf);
    }
    
    @Definition(position = 1, minLength = 1, maxLength = 2)
    public String getReportTransmissionCode() { return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 60)
    public String getName() { return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 256)
    public String getCommunicationNumber() { return collection[3]; }

    @Definition(position = 4, minLength = 2, maxLength = 2)
    public String getREFERENCEIDENTIFIER() { return collection[4]; }

    @Definition(position = 5, minLength = 2, maxLength = 2)
    public String getREFERENCEIDENTIFIER2() { return collection[5]; }

    public void setReportTransmissionCode(String s) { collection[1] = s; }
    public void setName(String s) { collection[2] = s; }
    public void setCommunicationNumber(String s) { collection[3] = s; }
    public void setREFERENCEIDENTIFIER(String s) { collection[4] = s; }
    public void setREFERENCEIDENTIFIER2(String s) { collection[5] = s; }
}
