package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by brianb on 5/4/17.
 * Based on work by xiaoerge.
 */
@Declaration(fieldSize = 4, name = "STC")
public class STC extends Segment {
    public STC() {
        super();
    }
    public STC(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 1, maxLength = 196, maxComponents = 3)
    public String getClaimStatus() {return getField(1); }
    
    public String getClaimStatusCategoryCode() {return getField(1,0); }
    public String getClaimStatusCode() {return getField(1,1); }
    public String getEntityIdentifierCode() {return getField(1,2); }

    @Definition(position = 2, minLength = 1, maxLength = 18)
    public String getStatusInformationEffectiveDate() {return getField(2); }

    @Definition(position = 3, minLength = 1, maxLength = 18)
    public String getTotalClaimChargeAmount() {return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 48)
    public String getClaimPaymentAmount() {return getField(4); }

    public void setClaimStatus(String s) { setField(1,s);}
    public void setClaimStatusCategoryCode(String s) { setField(1,0,s);}
    public void setClaimStatusCode(String s) { setField(1,1,s);}
    public void setEntityIdentifierCode(String s) { setField(1,2,s);}
    public void setStatusInformationEffectiveDate(String s) { setField(2,s);}
    public void setTotalClaimChargeAmount(String s) { setField(3,s);}
    public void setClaimPaymentAmount(String s) { setField(4,s);}
}
