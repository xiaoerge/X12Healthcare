package com.xiaoerge.x12.message.benefit.inquiry;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.MessageLoop;
import com.xiaoerge.x12.message.segment.*;
import com.xiaoerge.x12.util.SegmentStringUtil;
import com.xiaoerge.x12.util.StringQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitInquirySubscriber extends MessageLoop {
    private HL hierarchicalLevel;
    private List<TRN> traceNumbers;
    private NM1 name;
    private List<REF> additionalIdentifications;
    private N3 address;
    private N4 cityStateZip;
    private PRV providerInformation;
    private DMG demographic;
    private INS multipleBirthSequenceNumber;
    private HI healthCareDiagnosisCode;
    private List<DTP> dates;

    private List<BenefitInquirySubscriberEligibility> eligibilities;
    private List<BenefitInquiryDependent> dependents;

    public BenefitInquirySubscriber() {
        hierarchicalLevel = new HL();
        traceNumbers = new ArrayList<TRN>();
        name = new NM1();
        additionalIdentifications = new ArrayList<REF>();
        address = new N3();
        cityStateZip = new N4();
        providerInformation = new PRV();
        demographic = new DMG();
        multipleBirthSequenceNumber = new INS();
        healthCareDiagnosisCode = new HI();
        dates = new ArrayList<DTP>();
        eligibilities = new ArrayList<BenefitInquirySubscriberEligibility>();
        dependents = new ArrayList<BenefitInquiryDependent>();
    }
    public BenefitInquirySubscriber(String s, MessageFormat mf) {
        this();
        this.messageFormat = mf;
        StringQueue stringQueue = new StringQueue(s, mf);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HL"))
            hierarchicalLevel = new HL(stringQueue.getNext(), mf);
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("TRN"))
            traceNumbers.add(new TRN(stringQueue.getNext(), mf));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            name = new NM1(stringQueue.getNext(), mf);
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalIdentifications.add(new REF(stringQueue.getNext(), mf));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N3"))
            address = new N3(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N4"))
            cityStateZip = new N4(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PRV"))
            providerInformation = new PRV(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DMG"))
            demographic = new DMG(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("INS"))
            multipleBirthSequenceNumber = new INS(stringQueue.getNext(), mf);
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HI"))
            healthCareDiagnosisCode = new HI(stringQueue.getNext(), mf);
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            dates.add(new DTP(stringQueue.getNext(), mf));

        //find eligibility loop
        StringBuilder eligibilityString = new StringBuilder();
        while (stringQueue.hasNext() && !stringQueue.peekNext().startsWith("HL"))
            eligibilityString.append(stringQueue.getNext());

        String[] eqStrings = SegmentStringUtil.split(eligibilityString.toString(), "EQ", mf);
        for(String eqString : eqStrings) {
            eligibilities.add(new BenefitInquirySubscriberEligibility(eqString, mf));
        }

        //find dependent loop
        StringBuilder dependentString = new StringBuilder();
        while (stringQueue.hasNext()) {
            dependentString.append(stringQueue.getNext());
        }
        String[] dependentStrings = SegmentStringUtil.split(dependentString.toString(), "HL", mf);
        for(String dString : dependentStrings) {
            BenefitInquiryDependent dependent = new BenefitInquiryDependent(dString, mf);
            if (!dependent.getHierarchicalLevel().getHierarchicalParentIDNumber()
                    .equals(hierarchicalLevel.getHierarchicalIDNumber())){
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

        messagesDefinition.add(hierarchicalLevel);
        messagesDefinition.addAll(traceNumbers);
        messagesDefinition.add(name);
        messagesDefinition.addAll(additionalIdentifications);
        messagesDefinition.add(address);
        messagesDefinition.add(cityStateZip);
        messagesDefinition.add(providerInformation);
        messagesDefinition.add(demographic);
        messagesDefinition.add(multipleBirthSequenceNumber);
        messagesDefinition.add(healthCareDiagnosisCode);
        messagesDefinition.addAll(dates);
        messagesDefinition.addAll(eligibilities);
        messagesDefinition.addAll(dependents);
    }

    public HL getHierarchicalLevel() {
        return hierarchicalLevel;
    }

    public void setHierarchicalLevel(HL hierarchicalLevel) {
        this.hierarchicalLevel = hierarchicalLevel;
    }

    public List<TRN> getTraceNumbers() {
        return traceNumbers;
    }

    public void setTraceNumbers(List<TRN> traceNumbers) {
        this.traceNumbers = traceNumbers;
    }

    public NM1 getName() {
        return name;
    }

    public void setName(NM1 name) {
        this.name = name;
    }

    public List<REF> getAdditionalIdentifications() {
        return additionalIdentifications;
    }

    public void setAdditionalIdentifications(List<REF> additionalIdentifications) {
        this.additionalIdentifications = additionalIdentifications;
    }

    public N3 getAddress() {
        return address;
    }

    public void setAddress(N3 address) {
        this.address = address;
    }

    public N4 getCityStateZip() {
        return cityStateZip;
    }

    public void setCityStateZip(N4 cityStateZip) {
        this.cityStateZip = cityStateZip;
    }

    public PRV getProviderInformation() {
        return providerInformation;
    }

    public void setProviderInformation(PRV providerInformation) {
        this.providerInformation = providerInformation;
    }

    public DMG getDemographic() {
        return demographic;
    }

    public void setDemographic(DMG demographic) {
        this.demographic = demographic;
    }

    public INS getMultipleBirthSequenceNumber() {
        return multipleBirthSequenceNumber;
    }

    public void setMultipleBirthSequenceNumber(INS multipleBirthSequenceNumber) {
        this.multipleBirthSequenceNumber = multipleBirthSequenceNumber;
    }

    public HI getHealthCareDiagnosisCode() {
        return healthCareDiagnosisCode;
    }

    public void setHealthCareDiagnosisCode(HI healthCareDiagnosisCode) {
        this.healthCareDiagnosisCode = healthCareDiagnosisCode;
    }

    public List<DTP> getDates() {
        return dates;
    }

    public void setDates(List<DTP> dates) {
        this.dates = dates;
    }

    public List<BenefitInquirySubscriberEligibility> getEligibilities() {
        return eligibilities;
    }

    public void setEligibilities(List<BenefitInquirySubscriberEligibility> eligibilities) {
        this.eligibilities = eligibilities;
    }

    public List<BenefitInquiryDependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<BenefitInquiryDependent> dependents) {
        this.dependents = dependents;
    }
}
