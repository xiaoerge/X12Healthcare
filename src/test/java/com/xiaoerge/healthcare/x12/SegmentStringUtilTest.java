package com.xiaoerge.healthcare.x12;

import com.xiaoerge.healthcare.x12.util.SegmentStringUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaoerge on 5/30/16.
 */
public class SegmentStringUtilTest {

    @Test
    public void testSegmentSplit() {

        String x12 = "ISA*00*          *01*SECRET    *ZZ*SUBMITTERS   ID*ZZ*RECEIVERS    ID*030101*1253*^*00602*000000905*0*T*:~" +
                "GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~" +
                "ST*270*1234*005010X279A1~" +
                "BHT*0022*13*10001234*20060501*1319~" +
                "HL*1**20*1~" +
                "NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                "HL*2*1*21*1~" +
                "NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                "HL*3*2*22*0~" +
                "TRN*1*93175-012547*9877281234~" +
                "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                "DMG*D8*19430519~" +
                "DTP*291*D8*20060501~" +
                "EQ*30~" +
                "SE*13*1234~" +
                "GE*1*0616~" +
                "IEA*1*0616~";

        String[] splitArray = SegmentStringUtil.split(x12, "ISA");

        Assert.assertEquals(1, splitArray.length);
    }

    @Test
    public void testSegmentSplitRepeat() {

        String x12 = "EQ***~EQ***~EQ***~III***~EQ***~REF***~DTP***~EQ***~";

        String[] splitArray = SegmentStringUtil.split(x12, "EQ");

        Assert.assertEquals(5, splitArray.length);
        Assert.assertEquals("EQ***~", splitArray[0]);
        Assert.assertEquals("EQ***~", splitArray[1]);
        Assert.assertEquals("EQ***~III***~", splitArray[2]);
        Assert.assertEquals("EQ***~REF***~DTP***~", splitArray[3]);
        Assert.assertEquals("EQ***~", splitArray[4]);
    }

    @Test
    public void testSegmentSplitOne() {

        String x12 = "EQ***~";

        String[] splitArray = SegmentStringUtil.split(x12, "EQ");

        Assert.assertEquals(1, splitArray.length);
        Assert.assertEquals("EQ***~", splitArray[0]);
    }

    @Test
    public void testSegmentSplitBlank() {

        String x12 = "";

        String[] splitArray = SegmentStringUtil.split(x12, "EQ");

        Assert.assertEquals(0, splitArray.length);
    }

    @Test
    public void testSegmentSplitJoin() {

        String x12 = "HL*1**20*1~NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                "HL*2*1*21*1~NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                "HL*3*2*22*0~TRN*1*93175-012547*9877281234~NM1*IL*1*SMITH*ROBERT****MI*11122333301~DMG*D8*19430519~DTP*291*D8*20060501~EQ*30~" +
                "HL*4**20*1~NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                "HL*5*4*21*1~NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                "HL*6*5*22*0~TRN*1*93175-012547*9877281234~NM1*IL*1*SMITH*ROBERT****MI*11122333301~DMG*D8*19430519~DTP*291*D8*20060501~EQ*30~";

        String[] splitArray = SegmentStringUtil.split(x12, "HL");
        String[] levelArray = SegmentStringUtil.joinLevel(splitArray);

        Assert.assertEquals(2, levelArray.length);
        Assert.assertEquals("HL*1**20*1~" +
                "NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                "HL*2*1*21*1~" +
                "NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                "HL*3*2*22*0~" +
                "TRN*1*93175-012547*9877281234~" +
                "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                "DMG*D8*19430519~" +
                "DTP*291*D8*20060501~EQ*30~", levelArray[0]);

        Assert.assertEquals("HL*4**20*1~" +
                "NM1*PR*2*ABC COMPANY*****PI*842610001~" +
                "HL*5*4*21*1~" +
                "NM1*1P*2*BONE AND JOINT CLINIC*****SV*2000035~" +
                "HL*6*5*22*0~" +
                "TRN*1*93175-012547*9877281234~" +
                "NM1*IL*1*SMITH*ROBERT****MI*11122333301~" +
                "DMG*D8*19430519~" +
                "DTP*291*D8*20060501~EQ*30~",
                levelArray[1]);
    }
}
