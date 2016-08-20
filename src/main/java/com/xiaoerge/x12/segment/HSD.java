package com.xiaoerge.x12.segment;

import com.xiaoerge.x12.annotation.Declaration;
import com.xiaoerge.x12.annotation.Definition;

/**
 * Created by xiaoerge on 5/23/16.
 */
@Declaration(fieldSize = 8, name = "HSD")
public class HSD extends Segment {
    public HSD() {
        super();
    }
    public HSD(String content) {
        super(content);
    }

    @Definition(position = 1, minLength = 2, maxLength = 2)
    public String getQuantityQualifier() {return collection[1]; }

    @Definition(position = 2, minLength = 1, maxLength = 15)
    public String getQuantity() {return collection[2]; }

    @Definition(position = 3, minLength = 2, maxLength = 2)
    public String getUnitOrBasisForMeasurementCode() {return collection[3]; }

    @Definition(position = 4, minLength = 1, maxLength = 6)
    public String getSampleSelectionModulus() {return collection[4]; }

    @Definition(position = 5, minLength = 1, maxLength = 2)
    public String getTimePeriodQualifier() {return collection[5]; }

    @Definition(position = 6, minLength = 1, maxLength = 3)
    public String getNumberOfPeriods() {return collection[6]; }

    @Definition(position = 7, minLength = 1, maxLength = 2)
    public String getShipDeliveryOrCalendarPatternCode() {return collection[7]; }

    @Definition(position = 8, minLength = 1, maxLength = 1)
    public String getShipDeliveryPatternTimeCode() {return collection[8]; }

    public void setQuantityQualifier(String s) { collection[1] = s;}
    public void setQuantity(String s) { collection[2] = s;}
    public void setUnitOrBasisForMeasurementCode(String s) { collection[3] = s;}
    public void setSampleSelectionModulus(String s) { collection[4] = s;}
    public void setTimePeriodQualifier(String s) { collection[5] = s;}
    public void setNumberOfPeriods(String s) { collection[6] = s;}
    public void setShipDeliveryOrCalendarPatternCode(String s) { collection[7] = s;}
    public void setShipDeliveryPatternTimeCode(String s) { collection[8] = s;}
}
