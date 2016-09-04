package com.xiaoerge.x12.message.claim;

import com.xiaoerge.x12.message.benefit.inquiry.ClaimPayment;
import org.junit.Test;

/**
 * Created by xiaoerge on 9/3/16.
 */
public class ClaimPaymentTest {

    @Test
    public void testCreateClaimPayment() {
        String x12 = "ISA*00*          *00*          *ZZ*ABCCOM         *ZZ*99999999       *040315*1005*U*00401*004075123*0*P*:\n" +
                "GS*HP*ABCCOM*01017*20110315*1005*1*X*004010X091A1\n" +
                "ST*835*07504123\n" +
                "BPR*H*5.75*C*NON************20110315\n" +
                "TRN*1*A04B001017.07504*1346000128\n" +
                "DTM*405*20110308\n" +
                "N1*PR*ASHTABULA COUNTY ADAMH BD*XX*6457839886\n" +
                "N3*4817 STATE ROAD SUITE 203\n" +
                "N4*ASHTABULA*OH*44004\n" +
                "N1*PE*LAKE AREA RECOVERY CENTER *FI*346608640\n" +
                "N3*2801 C. COURT\n" +
                "N4*ASHTABULA*OH*44004\n" +
                "REF*PQ*1017\n" +
                "LX*1\n" +
                "CLP*444444*1*56.70*56.52*0*MC*0000000655555555*53\n" +
                "NM1*QC*1*FUDD*ELMER*S***MI*1333333\n" +
                "NM1*82*2*WECOVERWY SVCS*****FI*346608640\n" +
                "REF*F8*A76B04054\n" +
                "SVC*HC:H0005:HF:H9*56.70*56.52**6\n" +
                "DTM*472*20110205\n" +
                "CAS*CO*42*0.18*0\n" +
                "REF*6R*444444\n" +
                "CLP*999999*4*25.95*0*25.95*13*0000000555555555*11\n" +
                "NM1*QC*1*SAM*YOSEMITE*A***MI*3333333\n" +
                "NM1*82*2*ACME AGENCY*****FI*310626223\n" +
                "REF*F8*H57B10401\n" +
                "SVC*ZZ:M2200:HE*25.95*0**1\n" +
                "DTM*472*20021224\n" +
                "CAS*CR*18*25.95*0\n" +
                "CAS*CO*42*0*0\n" +
                "REF*6R*999999\n" +
                "CLP*888888*4*162.13*0*162.13*MC*0000000456789123*11\n" +
                "NM1*QC*1*SQUAREPANTS*BOB* ***MI*2222222\n" +
                "NM1*82*2*BIKINI AGENCY*****FI*310626223\n" +
                "REF*F8*H57B10401\n" +
                "SVC*ZZ:M151000:F0*162.13*0**1.9\n" +
                "DTM*472*20020920\n" +
                "CAS*CO*29*162.13*0*42*0*0\n" +
                "REF*6R*888888\n" +
                "CLP*111111*2*56.52*18.88*0*13*0000000644444444*53\n" +
                "NM1*QC*1*LEGHORN*FOGHORN*P***MI*7777777\n" +
                "NM1*82*2*CHICKENHAWK SVCS*****FI*346608640\n" +
                "REF*F8*A76B04054\n" +
                "SVC*HC:H0005:HF:H9*56.52*18.88**6\n" +
                "DTM*472*20031209\n" +
                "CAS*CO*42*0*0\n" +
                "CAS*OA*23*37.64*0\n" +
                "REF*6R*111111\n" +
                "CLP*121212*4*56.52*0*0*13*0000000646464640*53\n" +
                "NM1*QC*1*EXPLORER*DORA****MI*1717171\n" +
                "NM1*82*2*SWIPER AGENCY*****FI*346608640\n" +
                "REF*F8*A76B04054\n" +
                "SVC*HC:H0005:HF:H9*56.52*0**6\n" +
                "DTM*472*20031202\n" +
                "CAS*CO*42*0*0\n" +
                "CAS*OA*23*57.6*0*23*-1.08*0\n" +
                "REF*6R*121212\n" +
                "CLP*333333*1*74.61*59.69*14.92*13*0000000688888888*55\n" +
                "NM1*QC*1*BEAR*YOGI* ***MI*2222222\n" +
                "NM1*82*2*JELLYSTONE SVCS*****FI*346608640\n" +
                "REF*F8*A76B04054\n" +
                "SVC*ZZ:A0230:HF*74.61*59.69**1\n" +
                "DTM*472*20110203\n" +
                "CAS*PR*2*14.92*0\n" +
                "CAS*CO*42*0*0\n" +
                "REF*6R*333333\n" +
                "CLP*777777*25*136.9*0*0*13*0000000622222222*53\n" +
                "NM1*QC*1*BIRD*TWEETY*M***MI*4444444\n" +
                "NM1*82*2*GRANNY AGENCY*****FI*340716747\n" +
                "REF*F8*A76B03293\n" +
                "SVC*HC:H0015:HF:99:H9*136.9*0**1\n" +
                "DTM*472*20030911\n" +
                "CAS*PI*104*136.72*0\n" +
                "CAS*CO*42*0.18*0\n" +
                "REF*6R*777777\n" +
                "CLP*123456*22*-42.58*-42.58*0*13*0000000657575757*11\n" +
                "NM1*QC*1*SIMPSON*HOMER* ***MI*8787888\n" +
                "NM1*82*2*DOH GROUP*****FI*310626223\n" +
                "REF*F8*A57B04033\n" +
                "SVC*HC:H0036:GT:UK*-42.58*-42.58**-2\n" +
                "DTM*472*20110102\n" +
                "CAS*CR*141*0*0*42*0*0*22*0*0\n" +
                "CAS*OA*141*0*0\n" +
                "REF*6R*123456\n" +
                "CLP*090909*22*-86.76*-86.76*0*MC*0000000648484848*53\n" +
                "NM1*QC*1*DUCK*DAFFY*W***MI*1245849\n" +
                "NM1*82*2*ABTHSOLUTE HELP*****FI*346608640\n" +
                "REF*F8*A76B04054\n" +
                "SVC*HC:H0004:HF:H9*-86.76*-86.76**-4\n" +
                "DTM*472*20110210\n" +
                "CAS*CR*22*0*0*42*0*0\n" +
                "CAS*OA*22*0*0\n" +
                "REF*6R*090909\n" +
                "LQ*HE*MA92\n" +
                "SE*93*07504123\n" +
                "GE*1*1\n" +
                "IEA*1*004075123";

        ClaimPayment claimPayment = new ClaimPayment(x12);
    }
}
