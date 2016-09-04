package com.xiaoerge.x12.message.benefit.response;

import com.xiaoerge.x12.message.segment.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 8/12/16.
 */
public class BenefitResponseSubscriberTest {

    @Test
    public void testParseBenefitResponseSubscriber() {
        String subscriberString = "HL*3*2*22*1~" +
                    "NM1*IL*1*SMITH*JOHN****MI*123456789~" +
                    "N3*15197 BROADWAY AVENUE*APT 215~" +
                    "N4*KANSAS CITY*MO*64108~" +
                    "PRV*RF*PXC*207Q00000X~" +
                    "DMG*D8*19630519*M~";

        String dependentString = "HL*4*3*23*1~" +
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
                "EB*1**30**GOLD 123 PLAN~" +
                "EB*L~" +
                "LS*2120~" +
                "NM1*P3*1*JONES*MARCUS****SV*0202034~"+
                "LE*2120~";

        BenefitResponseSubscriber subscriber = new BenefitResponseSubscriber(subscriberString+dependentString);

        Assert.assertTrue(subscriber.validate());
        Assert.assertEquals(subscriberString+dependentString, subscriber.toString());
        Assert.assertEquals("HL*3*2*22*1~", subscriber.getHierarchicalLevel().toString());
        Assert.assertEquals("NM1*IL*1*SMITH*JOHN****MI*123456789~", subscriber.getName().toString());
        Assert.assertEquals("N3*15197 BROADWAY AVENUE*APT 215~", subscriber.getAddress().toString());
        Assert.assertEquals("N4*KANSAS CITY*MO*64108~", subscriber.getCityStateZip().toString());
        Assert.assertEquals("PRV*RF*PXC*207Q00000X~", subscriber.getProviderInformation().toString());
        Assert.assertEquals("DMG*D8*19630519*M~", subscriber.getDemographic().toString());

        Assert.assertEquals(1, subscriber.getDependents().size());
        Assert.assertEquals(dependentString, subscriber.getDependents().get(0).toString());
        Assert.assertEquals("3", subscriber.getDependents().get(0).getHierarchicalLevel().getHierarchicalParentIDNumber());
        Assert.assertEquals(2, subscriber.getDependents().get(0).getEligibilities().size());
    }

    @Test
    public void testCreateBenefitResponseSubscriber() {
        String subscriberString = "HL*3*2*22*1~" +
                "NM1*IL*1*SMITH*JOHN****MI*123456789~" +
                "N3*15197 BROADWAY AVENUE*APT 215~" +
                "N4*KANSAS CITY*MO*64108~" +
                "PRV*RF*PXC*207Q00000X~" +
                "DMG*D8*19630519*M~";

        String dependentString = "HL*4*3*23*1~" +
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
                "EB*1**30**GOLD 123 PLAN~" +
                "EB*L~" +
                "LS*2120~" +
                "NM1*P3*1*JONES*MARCUS****SV*0202034~"+
                "LE*2120~";

        BenefitResponseSubscriber subscriber = new BenefitResponseSubscriber();
        subscriber.setHierarchicalLevel(new HL("HL*3*2*22*1~"));
        subscriber.setName(new NM1("NM1*IL*1*SMITH*JOHN****MI*123456789~"));
        subscriber.setAddress(new N3("N3*15197 BROADWAY AVENUE*APT 215~"));
        subscriber.setCityStateZip(new N4("N4*KANSAS CITY*MO*64108~"));
        subscriber.setProviderInformation(new PRV("PRV*RF*PXC*207Q00000X~"));
        subscriber.setDemographic(new DMG("DMG*D8*19630519*M~"));

        subscriber.getDependents().add(new BenefitResponseDependent(dependentString));

        Assert.assertTrue(subscriber.validate());
        Assert.assertEquals(subscriberString+dependentString, subscriber.toString());
        Assert.assertEquals("HL*3*2*22*1~", subscriber.getHierarchicalLevel().toString());
        Assert.assertEquals("NM1*IL*1*SMITH*JOHN****MI*123456789~", subscriber.getName().toString());
        Assert.assertEquals("N3*15197 BROADWAY AVENUE*APT 215~", subscriber.getAddress().toString());
        Assert.assertEquals("N4*KANSAS CITY*MO*64108~", subscriber.getCityStateZip().toString());
        Assert.assertEquals("PRV*RF*PXC*207Q00000X~", subscriber.getProviderInformation().toString());
        Assert.assertEquals("DMG*D8*19630519*M~", subscriber.getDemographic().toString());

        Assert.assertEquals(1, subscriber.getDependents().size());
        Assert.assertEquals(dependentString, subscriber.getDependents().get(0).toString());
        Assert.assertEquals("3", subscriber.getDependents().get(0).getHierarchicalLevel().getHierarchicalParentIDNumber());
        Assert.assertEquals(2, subscriber.getDependents().get(0).getEligibilities().size());
    }
}
