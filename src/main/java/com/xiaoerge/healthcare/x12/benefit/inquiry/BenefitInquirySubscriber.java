package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.message.MessageBase;
import com.xiaoerge.healthcare.x12.util.SegmentStringUtil;
import com.xiaoerge.healthcare.x12.util.StringQueue;
import com.xiaoerge.healthcare.x12.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitInquirySubscriber extends MessageBase {
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
    private List<DTP> subscriberDate;

    private List<BenefitInquirySubscriberEligibility> subscriberEligibility;
    private List<BenefitInquiryDependent> dependents;

    public BenefitInquirySubscriber() {
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
        subscriberDate = new ArrayList<DTP>();
        subscriberEligibility = new ArrayList<BenefitInquirySubscriberEligibility>();
        dependents = new ArrayList<BenefitInquiryDependent>();
    }
    public BenefitInquirySubscriber(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HL"))
            subscriberLevel = new HL(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("TRN"))
            subscriberTraces.add(new TRN(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            subscriberName = new NM1(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalIdentification.add(new REF(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N3"))
            subscriberAddress = new N3(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N4"))
            subscriberCityState = new N4(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PRV"))
            providerInformation = new PRV(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DMG"))
            subscriberDemographic = new DMG(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("INS"))
            multipleBirthSequenceNumber = new INS(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HI"))
            subscriberHealthCareDiagnosisCode = new HI(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            subscriberDate.add(new DTP(stringQueue.getNext()));

        //find eligibility loop
        StringBuilder eligibilityString = new StringBuilder();
        while (stringQueue.hasNext() && !stringQueue.peekNext().startsWith("HL"))
            eligibilityString.append(stringQueue.getNext());

        String[] eqStrings = SegmentStringUtil.split(eligibilityString.toString(), "EQ");
        for(String eqString : eqStrings) {
            subscriberEligibility.add(new BenefitInquirySubscriberEligibility(eqString));
        }

        //find dependent loop
        StringBuilder dependentString = new StringBuilder();
        while (stringQueue.hasNext()) {
            dependentString.append(stringQueue.getNext());
        }
        String[] dependentStrings = SegmentStringUtil.split(dependentString.toString(), "HL");
        for(String dString : dependentStrings) {
            BenefitInquiryDependent dependent = new BenefitInquiryDependent(dString);
            if (!dependent.getDependentLevel().getHierarchicalParentIDNumber()
                    .equals(subscriberLevel.getHierarchicalIDNumber())){
                //there's a problem with this HL
                logger.error("Invalid HL found in BenefitInquirySubscriber to BenefitInquiryDependent "+ dependent.toString());
            }
            else {
                dependents.add(dependent);
            }
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(subscriberLevel);
        messagesDefinition.addAll(subscriberTraces);
        messagesDefinition.add(subscriberName);
        messagesDefinition.addAll(additionalIdentification);
        messagesDefinition.add(subscriberAddress);
        messagesDefinition.add(subscriberCityState);
        messagesDefinition.add(providerInformation);
        messagesDefinition.add(subscriberDemographic);
        messagesDefinition.add(multipleBirthSequenceNumber);
        messagesDefinition.add(subscriberHealthCareDiagnosisCode);
        messagesDefinition.addAll(subscriberDate);
        messagesDefinition.addAll(subscriberEligibility);
        messagesDefinition.addAll(dependents);
    }

    public HL getSubscriberLevel() {
        return subscriberLevel;
    }

    public void setSubscriberLevel(HL subscriberLevel) {
        this.subscriberLevel = subscriberLevel;
    }

    public List<TRN> getSubscriberTraces() {
        return subscriberTraces;
    }

    public void setSubscriberTraces(List<TRN> subscriberTraces) {
        this.subscriberTraces = subscriberTraces;
    }

    public NM1 getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(NM1 subscriberName) {
        this.subscriberName = subscriberName;
    }

    public List<REF> getAdditionalIdentification() {
        return additionalIdentification;
    }

    public void setAdditionalIdentification(List<REF> additionalIdentification) {
        this.additionalIdentification = additionalIdentification;
    }

    public N3 getSubscriberAddress() {
        return subscriberAddress;
    }

    public void setSubscriberAddress(N3 subscriberAddress) {
        this.subscriberAddress = subscriberAddress;
    }

    public N4 getSubscriberCityState() {
        return subscriberCityState;
    }

    public void setSubscriberCityState(N4 subscriberCityState) {
        this.subscriberCityState = subscriberCityState;
    }

    public PRV getProviderInformation() {
        return providerInformation;
    }

    public void setProviderInformation(PRV providerInformation) {
        this.providerInformation = providerInformation;
    }

    public DMG getSubscriberDemographic() {
        return subscriberDemographic;
    }

    public void setSubscriberDemographic(DMG subscriberDemographic) {
        this.subscriberDemographic = subscriberDemographic;
    }

    public INS getMultipleBirthSequenceNumber() {
        return multipleBirthSequenceNumber;
    }

    public void setMultipleBirthSequenceNumber(INS multipleBirthSequenceNumber) {
        this.multipleBirthSequenceNumber = multipleBirthSequenceNumber;
    }

    public HI getSubscriberHealthCareDiagnosisCode() {
        return subscriberHealthCareDiagnosisCode;
    }

    public void setSubscriberHealthCareDiagnosisCode(HI subscriberHealthCareDiagnosisCode) {
        this.subscriberHealthCareDiagnosisCode = subscriberHealthCareDiagnosisCode;
    }

    public List<DTP> getSubscriberDate() {
        return subscriberDate;
    }

    public void setSubscriberDate(List<DTP> subscriberDate) {
        this.subscriberDate = subscriberDate;
    }

    public List<BenefitInquirySubscriberEligibility> getSubscriberEligibility() {
        return subscriberEligibility;
    }

    public void setSubscriberEligibility(List<BenefitInquirySubscriberEligibility> subscriberEligibility) {
        this.subscriberEligibility = subscriberEligibility;
    }

    public List<BenefitInquiryDependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<BenefitInquiryDependent> dependents) {
        this.dependents = dependents;
    }
}
