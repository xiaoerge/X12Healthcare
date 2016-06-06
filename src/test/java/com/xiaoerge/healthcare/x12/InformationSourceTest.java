package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.control.Transaction;
import com.xiaoerge.healthcare.x12.level.InformationSource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class InformationSourceTest {

    @Test
    public void testParseInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        InformationSource informationSource = new InformationSource(x12);

        Assert.assertTrue(informationSource.validate());
        Assert.assertEquals(x12, informationSource.toX12String());
        Assert.assertEquals("1", informationSource.getHierarchicalIDNumber());
        Assert.assertEquals("20", informationSource.getHierarchicalLevelCode());
        Assert.assertEquals("1", informationSource.getHierarchicalChildCode());
        Assert.assertEquals("PR", informationSource.getEntityIdentifierCode());
        Assert.assertEquals("2", informationSource.getEntityTypeQualifier());
        Assert.assertEquals("ACE INSURANCE COMPANY", informationSource.getNameLastOrOrganizationName());
        Assert.assertEquals("PI", informationSource.getIdentificationCodeQualifier());
        Assert.assertEquals("87728", informationSource.getIdentificationCode());
    }

    @Test
    public void testCreateInformationSource() {
        String x12 = "HL*1**20*1~NM1*PR*2*ACE INSURANCE COMPANY*****PI*87728~";
        InformationSource informationSource = new InformationSource();

        informationSource.setHierarchicalIDNumber("1");
        informationSource.setHierarchicalLevelCode("20");
        informationSource.setHierarchicalChildCode("1");
        informationSource.setEntityIdentifierCode("PR");
        informationSource.setEntityTypeQualifier("2");
        informationSource.setNameLastOrOrganizationName("ACE INSURANCE COMPANY");
        informationSource.setIdentificationCodeQualifier("PI");
        informationSource.setIdentificationCode("87728");

        Assert.assertTrue(informationSource.validate());
        Assert.assertEquals(x12, informationSource.toX12String());
    }
}
