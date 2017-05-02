package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 7, name = "SVC")
public class SVC extends Segment {
    public SVC() {
        super();
    }
    public SVC(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 13, maxLength = 196)
    public String getCOMPOSITEMEDICALPROCEDUREIDENTIFIER() {return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getMonetaryAmount() {return collection[2]; }

    @Definition(position = 3, minLength = 1, maxLength = 18)
    public String getMonetaryAmount2() {return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 48)
    public String getProductServiceID() {return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 15)
    public String getQuantity() {return collection[5]; }

    @Definition(position = 6, minLength = 13, maxLength = 196)
    public String getCOMPOSITEMEDICALPROCEDUREIDENTIFIER2() {return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 15)
    public String getQuantity2() {return collection[7]; }

    public void setCOMPOSITEMEDICALPROCEDUREIDENTIFIER(String s) { collection[1] = s;}
    public void setMonetaryAmount(String s) { collection[2] = s;}
    public void setMonetaryAmount2(String s) { collection[3] = s;}
    public void setProductServiceID(String s) { collection[4] = s;}
    public void setQuantity(String s) { collection[4] = s;}
    public void setCOMPOSITEMEDICALPROCEDUREIDENTIFIER2(String s) { collection[4] = s;}
    public void setQuantity2(String s) { collection[4] = s;}
}
