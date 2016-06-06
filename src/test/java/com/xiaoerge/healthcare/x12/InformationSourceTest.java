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
        String x12 = "HL*1**20*1~NM1*1P*1*JONES*MARCUS*A*MR*MD*34*111223333*AA*BB*C~";
        InformationSource informationSource = new InformationSource(x12);

        Assert.assertTrue(informationSource.validate());
        Assert.assertEquals(x12, informationSource.toX12String());
    }

    @Test
    public void testCreateInformationSource() {
        String x12 = "HL*1**20*1~NM1*1P*1*JONES*MARCUS*A*MR*MD*34*111223333*AA*BB*C~";
        InformationSource informationSource = new InformationSource();

        Assert.assertTrue(informationSource.validate());
        Assert.assertEquals(x12, informationSource.toX12String());
    }
}
