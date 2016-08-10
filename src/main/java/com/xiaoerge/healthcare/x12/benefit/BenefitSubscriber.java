package com.xiaoerge.healthcare.x12.benefit;

import com.sun.org.apache.bcel.internal.generic.DNEG;
import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.segment.*;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitSubscriber implements IMessage {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private HL subscriberLevel;
    private List<TRN> subscriberTraces;
    private NM1 subscriberName;
    private List<REF> additionalIdentification;
    private N3 subscriberAddress;
    private N4 subscriberCityState;
    private PRV providerInformation;
    private DMG subscriberDemographic;
    private INS multipleBirthSequenceNumber;
    private HI subscriberHealthCareDiagnosisCode;
    private DTP subscriberDate;
    private EQ subscriberEligibility;
    private AMT subscriberSpendDown;
    private AMT subscriberTotalBilledAmount;
    private III subscriberAdditionalEligibility;
    private REF subscriberAdditionalInformation;
    private DTP subscriberEligibilityDate;

    public BenefitSubscriber() {
        subscriberLevel = new HL();
        subscriberTraces = new ArrayList<TRN>();
        subscriberName = new NM1();
        additionalIdentification = new ArrayList<REF>();
        subscriberAddress = new N3();
        subscriberCityState = new N4();
        providerInformation = new PRV();
        subscriberDemographic = new DMG();
        multipleBirthSequenceNumber = new INS();
        subscriberHealthCareDiagnosisCode = new HI();
        subscriberDate = new DTP();
        subscriberEligibility = new EQ();
        subscriberSpendDown = new AMT();
        subscriberTotalBilledAmount = new AMT();
        subscriberAdditionalEligibility = new III();
        subscriberAdditionalInformation = new REF();
        subscriberEligibilityDate = new DTP();
    }
    public BenefitSubscriber(String s) {
        this();
        StringBuilder stringBuilder = new StringBuilder();
        StringQueue stringQueue = new StringQueue(s);

        subscriberLevel = new HL(stringQueue.getNext());

        while (stringQueue.hasNext()) {
            String peek = stringQueue.peekNext();
            String next = stringQueue.getNext();
            if (peek.startsWith("HL") && new HL(peek).getHierarchicalParentIDNumber().equals(subscriberLevel.getHierarchicalIDNumber())) {

                //todo benefit dependent
                stringBuilder = new StringBuilder();

                logger.info("Start hierarchical level "+ next);
            }
            if (next.startsWith("TRN")) {
                subscriberTraces.add(new TRN(next));
                logger.info("Found TRN segment "+ next);
            }
            else if (next.startsWith("NM1")) {
                subscriberName = new NM1(next);
                logger.info("Found NM1 segment "+ next);
            }
            else if (next.startsWith("REF")) {
                additionalIdentification.add(new REF(next));
                logger.info("Found REF segment "+ next);
            }
            else if (next.startsWith("N3")) {
                subscriberAddress = new N3(next);
                logger.info("Found N3 segment "+ next);
            }
            else if (next.startsWith("N4")) {
                subscriberCityState = new N4(next);
                logger.info("Found N4 segment "+ next);
            }
            else if (next.startsWith("PRV")) {
                providerInformation = new PRV(next);
                logger.info("Found PRV segment "+ next);
            }

            else if (next.startsWith("DMG")) {
                subscriberDemographic = new DMG(next);
            }
            else if (next.startsWith("INS")) {
                multipleBirthSequenceNumber = new INS(next);
            }
            else if (next.startsWith("HI")) {
                subscriberHealthCareDiagnosisCode = new HI(next);
            }
            else if (next.startsWith("DTP")) {
                subscriberDate = new DTP(next);
            }
            else if (next.startsWith("EQ")) {
                subscriberEligibility = new EQ(next);
            }
            //todo better nest this parsing
            else if (next.startsWith("AMT")) {
                subscriberSpendDown = new AMT(next);
            }
            else if (next.startsWith("AMT")) {
                subscriberTotalBilledAmount = new AMT(next);
            }
            else if (next.startsWith("III")) {
                subscriberAdditionalEligibility = new III(next);
                logger.info("Found PRV segment "+ next);
            }
            else if (next.startsWith("REF")) {
                subscriberAdditionalInformation = new REF(next);
                logger.info("Found PRV segment "+ next);
            }
            else if (next.startsWith("DTP")) {
                subscriberEligibilityDate = new DTP(next);
                logger.info("Found PRV segment "+ next);
            }

            else {
                stringBuilder.append(next);
                logger.info("Found segment "+ next);
            }
        }
    }

    public boolean validate() {
        return false;
    }

    public String toX12String() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(subscriberLevel.toX12String());
        for (TRN trn : subscriberTraces) stringBuilder.append(trn.toX12String());

        stringBuilder.append(subscriberName.toX12String());
        for (REF ref : additionalIdentification) stringBuilder.append(ref.toX12String());
        stringBuilder.append(subscriberAddress.toX12String());
        stringBuilder.append(subscriberCityState.toX12String());
        stringBuilder.append(providerInformation.toX12String());
        stringBuilder.append(subscriberDemographic.toX12String());
        stringBuilder.append(multipleBirthSequenceNumber.toX12String());
        stringBuilder.append(subscriberHealthCareDiagnosisCode.toX12String());
        stringBuilder.append(subscriberDate.toX12String());
        stringBuilder.append(subscriberEligibility.toX12String());
        stringBuilder.append(subscriberSpendDown.toX12String());
        stringBuilder.append(subscriberTotalBilledAmount.toX12String());
        stringBuilder.append(subscriberAdditionalEligibility.toX12String());
        stringBuilder.append(subscriberAdditionalInformation.toX12String());
        stringBuilder.append(subscriberEligibilityDate.toX12String());

        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return false;
    }
}
