package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.benefit.inquiry.BenefitInquiryDependent;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 8/12/16.
 */
public class BenefitInquiryDependentTest {

    @Test
    public void testParseBenefitInquiry() {
        String x12 = "HL*6*5*22*0~" +
                    "TRN*1*93175-012547*9877281234~" +
                    "TRN*1*109834652831*WXYZCLEARH*REALTIME~" +
                    "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                    "DMG*D8*19430519~" +
                    "DTP*291*D8*20060501~" +
                    "EQ*30~" +
                    "III*ZZ*21~" +
                    "REF*9F*660415~" +
                    "DTP*291*D8*20051031~"+
                    "EQ*30~" +
                    "III*ZZ*21~" +
                    "REF*9F*660415~" +
                    "DTP*291*D8*20051031~"+
                    "EQ*30~" +
                    "III*ZZ*21~" +
                    "REF*9F*660415~" +
                    "DTP*291*D8*20051031~"+
                    "EQ*30~" +
                    "III*ZZ*21~" +
                    "REF*9F*660415~" +
                    "DTP*291*D8*20051031~"+
                    "EQ*30~" +
                    "III*ZZ*21~" +
                    "REF*9F*660415~" +
                    "DTP*291*D8*20051031~";

        BenefitInquiryDependent dependent = new BenefitInquiryDependent(x12);
        dependent.getDependentLevel();

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*6*5*22*0~", dependent.getDependentLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getDependentTraces().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getDependentTraces().get(1).toString());
        Assert.assertEquals(2, dependent.getDependentTraces().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getDependentName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDependentDate().get(0).toString());
    }
}
