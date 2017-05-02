package com.xiaoerge.x12.message.benefit.inquiry;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.segment.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by xiaoerge on 8/12/16.
 */
public class BenefitInquiryDependentTest {

    @Test
    public void testParseBenefitInquiryDepedent() {
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

        BenefitInquiryDependent dependent = new BenefitInquiryDependent(x12, new MessageFormat());

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*6*5*22*0~", dependent.getHierarchicalLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getTraceNumbers().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getTraceNumbers().get(1).toString());
        Assert.assertEquals(2, dependent.getTraceNumbers().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getName().toString());
        Assert.assertEquals(9, dependent.getAdditionalIdentifications().size());

        for(int i = 0; i < 9; i++) {
            REF additionalInformation = dependent.getAdditionalIdentifications().get(i);
            Assert.assertEquals("REF*1L*660415~", additionalInformation.toString());
        }

        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDates().get(0).toString());

        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility = dependent.getEligibilities().get(i);
            Assert.assertEquals("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~",
                    benefitInquiryDependentEligibility.toString());
        }
        Assert.assertEquals(5, dependent.getEligibilities().size());
    }

    @Test
    public void testCreateBenefitInquiryDependent() {
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

        MessageFormat mf = new MessageFormat();
        BenefitInquiryDependent dependent = new BenefitInquiryDependent();
        dependent.setHierarchicalLevel(new HL("HL*6*5*22*0~", mf));
        dependent.setTraceNumbers(new ArrayList<TRN>());
        dependent.getTraceNumbers().add(new TRN("TRN*1*93175-012547*9877281234~", mf));
        dependent.getTraceNumbers().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~", mf));
        dependent.setName(new NM1("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", mf));
        for(int i = 0; i < 9; i++) {
            REF additionalInformation = new REF("REF*1L*660415~", mf);
            dependent.getAdditionalIdentifications().add(additionalInformation);
        }
        dependent.setDates(new ArrayList<DTP>());
        dependent.setDemographicInformation(new DMG("DMG*D8*19430519~", mf));
        dependent.getDates().add(new DTP("DTP*291*D8*20060501~", mf));
        dependent.setEligibilities(new ArrayList<BenefitInquiryDependentEligibility>());
        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility =
                    new BenefitInquiryDependentEligibility("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~", mf);

            dependent.getEligibilities().add(benefitInquiryDependentEligibility);
        }

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*6*5*22*0~", dependent.getHierarchicalLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getTraceNumbers().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getTraceNumbers().get(1).toString());
        Assert.assertEquals(2, dependent.getTraceNumbers().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDates().get(0).toString());
        Assert.assertEquals(5, dependent.getEligibilities().size());
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

        MessageFormat mf = new MessageFormat();
        BenefitInquiryDependent dependent = new BenefitInquiryDependent();
        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility =
                    new BenefitInquiryDependentEligibility("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~", mf);

            dependent.getEligibilities().add(benefitInquiryDependentEligibility);
        }
        dependent.setName(new NM1("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", mf));
        dependent.setDemographicInformation(new DMG("DMG*D8*19430519~", mf));
        dependent.getDates().add(new DTP("DTP*291*D8*20060501~", mf));
        dependent.setHierarchicalLevel(new HL("HL*6*5*22*0~", mf));
        dependent.getTraceNumbers().add(new TRN("TRN*1*93175-012547*9877281234~", mf));
        dependent.getTraceNumbers().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~", mf));

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*6*5*22*0~", dependent.getHierarchicalLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getTraceNumbers().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getTraceNumbers().get(1).toString());
        Assert.assertEquals(2, dependent.getTraceNumbers().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDates().get(0).toString());
        Assert.assertEquals(5, dependent.getEligibilities().size());
    }
}
