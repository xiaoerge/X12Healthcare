package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.message.BenefitInquiry;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitInquiryTest {

    @Test
    public void testParseBenefitInquiry() {
        String x12 = "ISA****************~GS********~ST*270**~BHT******~SE**~GE**~IEA**~";
        BenefitInquiry message = (BenefitInquiry) X12Parser.fromX12Message(x12);

        Assert.assertFalse(message.validate());
        Assert.assertEquals(message.toX12String(), message.toString());
    }
}
