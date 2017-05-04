package com.xiaoerge.x12.message.benefit.response;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.segment.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by xiaoerge on 8/12/16.
 */
public class BenefitResponseDependentTest {

    @Test
    public void testParseBenefitResponseDepedent() {
        String x12 = "HL*4*3*23*1~" +
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

        BenefitResponseDependent dependent = new BenefitResponseDependent(x12, new MessageFormat());

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*4*3*23*1~", dependent.getHierarchicalLevel().toString());
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

        BenefitResponseEligibility eligibility = dependent.getEligibilities().get(0);
        Assert.assertEquals("EB*1**30**GOLD 123 PLAN~",
                eligibility.toString());
        eligibility = dependent.getEligibilities().get(1);
        Assert.assertEquals("EB*L~LS*2120~NM1*P3*1*JONES*MARCUS****SV*0202034~LE*2120~",
                eligibility.toString());

        Assert.assertEquals(2, dependent.getEligibilities().size());
    }

    @Test
    public void testCreateBenefitResponseDependent() {
        String x12 = "HL*4*3*23*1~" +
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

        MessageFormat mf = new MessageFormat();
        BenefitResponseDependent dependent = new BenefitResponseDependent();
        dependent.setHierarchicalLevel(new HL("HL*4*3*23*1~", mf));
        dependent.setTraceNumbers(new ArrayList<TRN>());
        dependent.getTraceNumbers().add(new TRN("TRN*1*93175-012547*9877281234~", mf));
        dependent.getTraceNumbers().add(new TRN("TRN*1*109834652831*WXYZCLEARH*REALTIME~", mf));
        dependent.setName(new NM1("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", mf));
        for(int i = 0; i < 9; i++) {
            REF additionalInformation = new REF("REF*1L*660415~", mf);
            dependent.getAdditionalIdentifications().add(additionalInformation);
        }
        dependent.setDates(new ArrayList<DTP>());
        dependent.setDemographic(new DMG("DMG*D8*19430519~", mf));
        dependent.getDates().add(new DTP("DTP*291*D8*20060501~", mf));
        dependent.setEligibilities(new ArrayList<BenefitResponseEligibility>());

        dependent.getEligibilities().add(new BenefitResponseEligibility("EB*1**30**GOLD 123 PLAN~", mf));
        dependent.getEligibilities().add(new BenefitResponseEligibility("EB*L~LS*2120~NM1*P3*1*JONES*MARCUS****SV*0202034~LE*2120~", mf));

        Assert.assertTrue(dependent.validate());
        Assert.assertEquals(x12, dependent.toString());
        Assert.assertEquals("HL*4*3*23*1~", dependent.getHierarchicalLevel().toString());
        Assert.assertEquals("TRN*1*93175-012547*9877281234~", dependent.getTraceNumbers().get(0).toString());
        Assert.assertEquals("TRN*1*109834652831*WXYZCLEARH*REALTIME~", dependent.getTraceNumbers().get(1).toString());
        Assert.assertEquals(2, dependent.getTraceNumbers().size());
        Assert.assertEquals("NM1*IL*1*SMITH*ROBERT****MI*11122333301~", dependent.getName().toString());
        Assert.assertEquals("DTP*291*D8*20060501~", dependent.getDates().get(0).toString());
        Assert.assertEquals(2, dependent.getEligibilities().size());
    }
}
