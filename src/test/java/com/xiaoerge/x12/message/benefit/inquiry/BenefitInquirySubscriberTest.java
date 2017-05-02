package com.xiaoerge.x12.message.benefit.inquiry;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.segment.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 8/12/16.
 */
public class BenefitInquirySubscriberTest {

    @Test
    public void testParseBenefitInquirySubscriber() {
        String subscriberString = "HL*5*4*22*1~" +
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
                    "EQ*31**FAM~" +
                    "EQ*32**FAM~" +
                    "EQ*33**FAM~" +
                    "EQ*34**FAM~";

        String dependentString = "HL*6*5*22*0~" +
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

        BenefitInquirySubscriber subscriber = new BenefitInquirySubscriber(subscriberString+dependentString, new MessageFormat());

        Assert.assertTrue(subscriber.validate());
        Assert.assertEquals(subscriberString+dependentString, subscriber.toString());
        Assert.assertEquals("HL*5*4*22*1~", subscriber.getHierarchicalLevel().toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", subscriber.getTraceNumbers().get(0).toString());
        Assert.assertEquals(1, subscriber.getTraceNumbers().size());
        Assert.assertEquals("NM1*IL*1*SMITH*JOHN*L***MI*444115555~", subscriber.getName().toString());
        Assert.assertEquals("REF*1L*660415~", subscriber.getAdditionalIdentifications().get(0).toString());
        Assert.assertEquals("N3*15197 BROADWAY AVENUE*APT 215~", subscriber.getAddress().toString());
        Assert.assertEquals("N4*KANSAS CITY*MO*64108~", subscriber.getCityStateZip().toString());
        Assert.assertEquals("PRV*RF*PXC*207Q00000X~", subscriber.getProviderInformation().toString());
        Assert.assertEquals("DMG*D8*19430917*M~", subscriber.getDemographic().toString());
        Assert.assertEquals("INS*Y*18***************3~", subscriber.getMultipleBirthSequenceNumber().toString());
        Assert.assertEquals("HI*BK:8901*BF:87200*BF:5559~", subscriber.getHealthCareDiagnosisCode().toString());
        Assert.assertEquals("DTP*281*D8*20051015~", subscriber.getDates().get(0).toString());
        Assert.assertEquals("DTP*291*D8*20051015~", subscriber.getDates().get(1).toString());
        Assert.assertEquals(2, subscriber.getDates().size());

        for(int i = 0; i < 5; i++) {
            BenefitInquirySubscriberEligibility benefitInquirySubscriberEligibility = subscriber.getEligibilities().get(i);
            Assert.assertEquals("EQ*"+(30+i)+"**FAM~",
                    benefitInquirySubscriberEligibility.toString());
        }
        Assert.assertEquals(5, subscriber.getEligibilities().size());

        Assert.assertEquals(1, subscriber.getDependents().size());
        Assert.assertEquals(dependentString, subscriber.getDependents().get(0).toString());
        Assert.assertEquals("5", subscriber.getDependents().get(0).getHierarchicalLevel().getHierarchicalParentIDNumber());
        Assert.assertEquals(5, subscriber.getDependents().get(0).getEligibilities().size());
    }

    @Test
    public void testCreateBenefitInquirySubscriber() {
        String subscriberString = "HL*5*4*22*1~" +
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
                "EQ*31**FAM~" +
                "EQ*32**FAM~" +
                "EQ*33**FAM~" +
                "EQ*34**FAM~";

        String dependentString = "HL*6*5*22*0~" +
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
        BenefitInquirySubscriber subscriber = new BenefitInquirySubscriber();
        subscriber.setHierarchicalLevel(new HL("HL*5*4*22*1~", mf));
        subscriber.getTraceNumbers().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~", mf));
        subscriber.setName(new NM1("NM1*IL*1*SMITH*JOHN*L***MI*444115555~", mf));
        subscriber.getAdditionalIdentifications().add(new REF("REF*1L*660415~", mf));
        subscriber.setAddress(new N3("N3*15197 BROADWAY AVENUE*APT 215~", mf));
        subscriber.setCityStateZip(new N4("N4*KANSAS CITY*MO*64108~", mf));
        subscriber.setProviderInformation(new PRV("PRV*RF*PXC*207Q00000X~", mf));
        subscriber.setDemographic(new DMG("DMG*D8*19430917*M~", mf));
        subscriber.setMultipleBirthSequenceNumber(new INS("INS*Y*18***************3~", mf));
        subscriber.setHealthCareDiagnosisCode(new HI("HI*BK:8901*BF:87200*BF:5559~", mf));
        subscriber.getDates().add(new DTP("DTP*281*D8*20051015~", mf));
        subscriber.getDates().add(new DTP("DTP*291*D8*20051015~", mf));

        for(int i = 0; i < 5; i++) {
            subscriber.getEligibilities().add(new BenefitInquirySubscriberEligibility("EQ*"+(30+i)+"**FAM~", mf));
        }
        subscriber.getDependents().add(new BenefitInquiryDependent(dependentString, mf));

        Assert.assertTrue(subscriber.validate());
        Assert.assertEquals(subscriberString+dependentString, subscriber.toString());
        Assert.assertEquals("HL*5*4*22*1~", subscriber.getHierarchicalLevel().toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", subscriber.getTraceNumbers().get(0).toString());
        Assert.assertEquals(1, subscriber.getTraceNumbers().size());
        Assert.assertEquals("NM1*IL*1*SMITH*JOHN*L***MI*444115555~", subscriber.getName().toString());
        Assert.assertEquals("REF*1L*660415~", subscriber.getAdditionalIdentifications().get(0).toString());
        Assert.assertEquals("N3*15197 BROADWAY AVENUE*APT 215~", subscriber.getAddress().toString());
        Assert.assertEquals("N4*KANSAS CITY*MO*64108~", subscriber.getCityStateZip().toString());
        Assert.assertEquals("PRV*RF*PXC*207Q00000X~", subscriber.getProviderInformation().toString());
        Assert.assertEquals("DMG*D8*19430917*M~", subscriber.getDemographic().toString());
        Assert.assertEquals("INS*Y*18***************3~", subscriber.getMultipleBirthSequenceNumber().toString());
        Assert.assertEquals("HI*BK:8901*BF:87200*BF:5559~", subscriber.getHealthCareDiagnosisCode().toString());
        Assert.assertEquals("DTP*281*D8*20051015~", subscriber.getDates().get(0).toString());
        Assert.assertEquals("DTP*291*D8*20051015~", subscriber.getDates().get(1).toString());
        Assert.assertEquals(2, subscriber.getDates().size());

        for(int i = 0; i < 5; i++) {
            BenefitInquirySubscriberEligibility benefitInquirySubscriberEligibility = subscriber.getEligibilities().get(i);
            Assert.assertEquals("EQ*"+(30+i)+"**FAM~",
                    benefitInquirySubscriberEligibility.toString());
        }
        Assert.assertEquals(5, subscriber.getEligibilities().size());

        Assert.assertEquals(1, subscriber.getDependents().size());
        Assert.assertEquals(dependentString, subscriber.getDependents().get(0).toString());
        Assert.assertEquals("5", subscriber.getDependents().get(0).getHierarchicalLevel().getHierarchicalParentIDNumber());
        Assert.assertEquals(5, subscriber.getDependents().get(0).getEligibilities().size());
    }
}
