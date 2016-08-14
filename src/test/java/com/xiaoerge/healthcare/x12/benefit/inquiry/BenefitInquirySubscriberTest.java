package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.segment.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by xiaoerge on 8/12/16.
 */
public class BenefitInquirySubscriberTest {

    @Test
    public void testParseBenefitSubscriberInquiry() {
        String x12 = "HL*5*4*22*1~" +
                    "TRN*1*109834652831*WXYZCLEARH*REALTIME~" +
                    "NM1*IL*1*SMITH*JOHN*L***MI*444115555~" +
                    "REF*1L*660415~" +
                    "N3*15197 BROADWAY AVENUE*APT 215~" +
                    "N4*KANSAS CITY*MO*64108~" +
                    "PRV*RF*PXC*207Q00000X~" +
                    "DMG*D8*19430917*M~" +
                    "INS*Y*18***************3~" +
                    "HI*BK:8901*BF:87200*BF:5559~" +
                    "DTP*281*D8*20051015~" +
                    "DTP*291*D8*20051015~" +
                    "EQ*30**FAM~" +
                    "HL*6*5*22*0~" +
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

        BenefitInquirySubscriber subscriber = new BenefitInquirySubscriber(x12);

//        Assert.assertTrue(subscriber.validate());
//        Assert.assertEquals(x12, subscriber.toString());
//        Assert.assertEquals("HL*6*5*22*0~", subscriber.getSubscriberLevel().toString());
//        Assert.assertEquals("TRN*1*93175-012547*9877281234~", subscriber.getSubscriberTraces().get(0).toString());
//        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", subscriber.getSubscriberTraces().get(1).toString());
//        Assert.assertEquals(2, subscriber.getSubscriberTraces().size());
//        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", subscriber.getSubscriberName().toString());
//        Assert.assertEquals("DTP*291*D8*20060501~", subscriber.getSubscriberDate().get(0).toString());
//
//        for(int i = 0; i < 5; i++) {
//            BenefitInquirySubscriberEligibility benefitInquirySubscriberEligibility = subscriber.getSubscriberEligibility().get(i);
//            Assert.assertEquals("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~",
//                    benefitInquirySubscriberEligibility.toString());
//        }
//        Assert.assertEquals(5, subscriber.getSubscriberEligibility().size());
    }

    @Test
    public void testCreateBenefitSubscriberInquiry() {
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

        BenefitInquiryDependent subscriber = new BenefitInquiryDependent();
        subscriber.setDependentLevel(new HL("HL*6*5*22*0~"));
        subscriber.setDependentTraces(new ArrayList<TRN>());
        subscriber.getDependentTraces().add(new TRN("TRN*1*93175-012547*9877281234~"));
        subscriber.getDependentTraces().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~"));
        subscriber.setDependentName(new NM1("NM1*IL*1*SMITH*ROBERT****MI*11122333301~"));
        subscriber.setDependentDate(new ArrayList<DTP>());
        subscriber.setDependentDemographic(new DMG("DMG*D8*19430519~"));
        subscriber.getDependentDate().add(new DTP("DTP*291*D8*20060501~"));
        subscriber.setDependentEligibility(new ArrayList<BenefitInquiryDependentEligibility>());
        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility =
                    new BenefitInquiryDependentEligibility("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~");

            subscriber.getDependentEligibility().add(benefitInquiryDependentEligibility);
        }

        Assert.assertTrue(subscriber.validate());
        Assert.assertEquals(x12, subscriber.toString());
        Assert.assertEquals("HL*6*5*22*0~", subscriber.getDependentLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", subscriber.getDependentTraces().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", subscriber.getDependentTraces().get(1).toString());
        Assert.assertEquals(2, subscriber.getDependentTraces().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", subscriber.getDependentName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", subscriber.getDependentDate().get(0).toString());
        Assert.assertEquals(5, subscriber.getDependentEligibility().size());
    }

    @Test
    public void testCreateBenefitInquirySuscriberRandomOrder() {
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

        BenefitInquiryDependent subscriber = new BenefitInquiryDependent();
        for(int i = 0; i < 5; i++) {
            BenefitInquiryDependentEligibility benefitInquiryDependentEligibility =
                    new BenefitInquiryDependentEligibility("EQ*30~III*ZZ*21~REF*9F*660415~DTP*291*D8*20051031~");

            subscriber.getDependentEligibility().add(benefitInquiryDependentEligibility);
        }
        subscriber.setDependentName(new NM1("NM1*IL*1*SMITH*ROBERT****MI*11122333301~"));
        subscriber.setDependentDemographic(new DMG("DMG*D8*19430519~"));
        subscriber.getDependentDate().add(new DTP("DTP*291*D8*20060501~"));
        subscriber.setDependentLevel(new HL("HL*6*5*22*0~"));
        subscriber.getDependentTraces().add(new TRN("TRN*1*93175-012547*9877281234~"));
        subscriber.getDependentTraces().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~"));

        Assert.assertTrue(subscriber.validate());
        Assert.assertEquals(x12, subscriber.toString());
        Assert.assertEquals("HL*6*5*22*0~", subscriber.getDependentLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", subscriber.getDependentTraces().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", subscriber.getDependentTraces().get(1).toString());
        Assert.assertEquals(2, subscriber.getDependentTraces().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", subscriber.getDependentName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", subscriber.getDependentDate().get(0).toString());
        Assert.assertEquals(5, subscriber.getDependentEligibility().size());
    }
}
