package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.benefit.BenefitDependent;
import com.xiaoerge.healthcare.x12.benefit.BenefitInquiryTransaction;
import com.xiaoerge.healthcare.x12.control.FunctionalGroup;
import com.xiaoerge.healthcare.x12.control.InterchangeEnvelope;
import com.xiaoerge.healthcare.x12.control.Transaction;
import com.xiaoerge.healthcare.x12.message.BenefitInquiry;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class BenefitDependentTest {

    @Test
    public void testParseBenefitInquiry() {
        String x12 = "HL*4**20*1~" + //new loop
                    "NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                        "HL*5*4*21*1~" +
                        "NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                            "HL*6*5*22*0~" +
                            "TRN*1*93175-012547*9877281234~" +
                            "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                            "DMG*D8*19430519~" +
                            "DTP*291*D8*20060501~" +
                            "EQ*30~";

        BenefitDependent dependent = new BenefitDependent(x12);

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(dependent.toX12String(), dependent.toString());
    }
}
