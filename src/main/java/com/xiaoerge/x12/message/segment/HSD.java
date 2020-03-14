package com.xiaoerge.x12.message.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;
import com.xiaoerge.x12.message.MessageFormat;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 8, name = "HSD")
public class HSD extends Segment {
    public HSD() {
        super();
    }
    public HSD(String content, MessageFormat mf) {
        super(content, mf);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getQuantityQualifier() {return getField(1); }

    @Definition(position = 2, minLength = 1, maxLength = 15)
    public String getQuantity() {return getField(2); }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getUnitOrBasisForMeasurementCode() {return getField(3); }

    @Definition(position = 4, minLength = 1, maxLength = 6)
    public String getSampleSelectionModulus() {return getField(4); }

    @Definition(position = 5, minLength = 1, maxLength = 2)
    public String getTimePeriodQualifier() {return getField(5); }

    @Definition(position = 6, minLength = 1, maxLength = 3)
    public String getNumberOfPeriods() {return getField(6); }

    @Definition(position = 7, minLength = 1, maxLength = 2)
    public String getShipDeliveryOrCalendarPatternCode() {return getField(7); }

    @Definition(position = 8, minLength = 1, maxLength = 1)
    public String getShipDeliveryPatternTimeCode() {return getField(8); }

    public void setQuantityQualifier(String s) { setField(1,s);}
    public void setQuantity(String s) { setField(2,s);}
    public void setUnitOrBasisForMeasurementCode(String s) { setField(3,s);}
    public void setSampleSelectionModulus(String s) { setField(4,s);}
    public void setTimePeriodQualifier(String s) { setField(5,s);}
    public void setNumberOfPeriods(String s) { setField(6,s);}
    public void setShipDeliveryOrCalendarPatternCode(String s) { setField(7,s);}
    public void setShipDeliveryPatternTimeCode(String s) { setField(8,s);}
}
