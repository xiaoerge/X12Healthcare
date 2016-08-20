package com.xiaoerge.x12.benefit.inquiry;

import com.xiaoerge.x12.segment.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by xiaoerge on 8/12/16.
 */
public class BenefitInquiryDependentTest {

    @Test
    public void testParseBenefitDepedentInquiry() {
        String x12 = "HL*6*5*22*0~" +
                    "TRN*1*93175-012547*9877281234~" +
                    "TRN*1*109834652831*WXYZCLEARH*REALTIME~" +
                    "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
                    "REF*1L*660415~" +
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

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*6*5*22*0~", dependent.getDependentLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getDependentTraces().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getDependentTraces().get(1).toString());
        Assert.assertEquals(2, dependent.getDependentTraces().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getDependentName().toString());
        Assert.assertEquals(9, dependent.getAdditionalIdentification().size());

        for(int i = 0; i < 9; i++) {
            REF additionalInformation = dependent.getAdditionalIdentification().get(i);
            Assert.assertEquals("REF*1L*660415~", additionalInformation.toString());
        }

        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDependentDate().get(0).toString());

        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility = dependent.getDependentEligibility().get(i);
            Assert.assertEquals("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~",
                    benefitInquiryDependentEligibility.toString());
        }
        Assert.assertEquals(5, dependent.getDependentEligibility().size());
    }

    @Test
    public void testCreateBenefitDependentInquiry() {
        String x12 = "HL*6*5*22*0~" +
                "TRN*1*93175-012547*9877281234~" +
                "TRN*1*109834652831*WXYZCLEARH*REALTIME~" +
                "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
                "REF*1L*660415~" +
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

        BenefitInquiryDependent dependent = new BenefitInquiryDependent();
        dependent.setDependentLevel(new HL("HL*6*5*22*0~"));
        dependent.setDependentTraces(new ArrayList<TRN>());
        dependent.getDependentTraces().add(new TRN("TRN*1*93175-012547*9877281234~"));
        dependent.getDependentTraces().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~"));
        dependent.setDependentName(new NM1("NM1*IL*1*SMITH*ROBERT****MI*11122333301~"));
        for(int i = 0; i < 9; i++) {
            REF additionalInformation = new REF("REF*1L*660415~");
            dependent.getAdditionalIdentification().add(additionalInformation);
        }
        dependent.setDependentDate(new ArrayList<DTP>());
        dependent.setDependentDemographic(new DMG("DMG*D8*19430519~"));
        dependent.getDependentDate().add(new DTP("DTP*291*D8*20060501~"));
        dependent.setDependentEligibility(new ArrayList<BenefitInquiryDependentEligibility>());
        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility =
                    new BenefitInquiryDependentEligibility("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~");

            dependent.getDependentEligibility().add(benefitInquiryDependentEligibility);
        }

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*6*5*22*0~", dependent.getDependentLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getDependentTraces().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getDependentTraces().get(1).toString());
        Assert.assertEquals(2, dependent.getDependentTraces().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getDependentName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDependentDate().get(0).toString());
        Assert.assertEquals(5, dependent.getDependentEligibility().size());
    }

    @Test
    public void testCreateBenefitInquiryDependentRandomOrder() {
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

        BenefitInquiryDependent dependent = new BenefitInquiryDependent();
        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility =
                    new BenefitInquiryDependentEligibility("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~");

            dependent.getDependentEligibility().add(benefitInquiryDependentEligibility);
        }
        dependent.setDependentName(new NM1("NM1*IL*1*SMITH*ROBERT****MI*11122333301~"));
        dependent.setDependentDemographic(new DMG("DMG*D8*19430519~"));
        dependent.getDependentDate().add(new DTP("DTP*291*D8*20060501~"));
        dependent.setDependentLevel(new HL("HL*6*5*22*0~"));
        dependent.getDependentTraces().add(new TRN("TRN*1*93175-012547*9877281234~"));
        dependent.getDependentTraces().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~"));

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*6*5*22*0~", dependent.getDependentLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getDependentTraces().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getDependentTraces().get(1).toString());
        Assert.assertEquals(2, dependent.getDependentTraces().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getDependentName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDependentDate().get(0).toString());
        Assert.assertEquals(5, dependent.getDependentEligibility().size());
    }
}
