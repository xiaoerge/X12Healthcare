package com.xiaoerge.x12.benefit.inquiry;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.util.SegmentStringUtil;
import com.xiaoerge.x12.util.StringQueue;
import com.xiaoerge.x12.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitInquiryDependent extends MessageBase {
    private HL hierarchicalLevel;
    private List<TRN> traceNumber;
    private NM1 name;
    private List<REF> additionalIdentification;
    private N3 address;
    private N4 cityStateZip;
    private PRV providerInformation;
    private DMG demographicInformation;
    private INS relationship;
    private HI healthCareDiagnosisCode;
    private List<DTP> date;

    private List<BenefitInquiryDependentEligibility> dependentEligibility;

    public BenefitInquiryDependent() {
        hierarchicalLevel = new HL();
        traceNumber = new ArrayList<TRN>();
        name = new NM1();
        additionalIdentification = new ArrayList<REF>();
        address = new N3();
        cityStateZip = new N4();
        providerInformation = new PRV();
        demographicInformation = new DMG();
        relationship = new INS();
        healthCareDiagnosisCode = new HI();
        date = new ArrayList<DTP>();
        dependentEligibility = new ArrayList<BenefitInquiryDependentEligibility>();
    }
    public BenefitInquiryDependent(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HL"))
            hierarchicalLevel = new HL(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("TRN"))
            traceNumber.add(new TRN(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            name = new NM1(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalIdentification.add(new REF(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N3"))
            address = new N3(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N4"))
            cityStateZip = new N4(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PRV"))
            providerInformation = new PRV(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DMG"))
            demographicInformation = new DMG(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("INS"))
            relationship = new INS(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HI"))
            healthCareDiagnosisCode = new HI(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            date.add(new DTP(stringQueue.getNext()));

        StringBuilder builder = new StringBuilder();
        while (stringQueue.hasNext()) {
            builder.append(stringQueue.getNext());
        }

        String[] splitArray = SegmentStringUtil.split(builder.toString(), "EQ");
        for(String str : splitArray) {
            dependentEligibility.add(new BenefitInquiryDependentEligibility(str));
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(hierarchicalLevel);
        messagesDefinition.addAll(traceNumber);
        messagesDefinition.add(name);
        messagesDefinition.addAll(additionalIdentification);
        messagesDefinition.add(address);
        messagesDefinition.add(cityStateZip);
        messagesDefinition.add(providerInformation);
        messagesDefinition.add(demographicInformation);
        messagesDefinition.add(relationship);
        messagesDefinition.add(healthCareDiagnosisCode);
        messagesDefinition.addAll(date);
        messagesDefinition.addAll(dependentEligibility);
    }


    public HL getHierarchicalLevel() {
        return hierarchicalLevel;
    }

    public void setHierarchicalLevel(HL hierarchicalLevel) {
        this.hierarchicalLevel = hierarchicalLevel;
    }

    public List<TRN> getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(List<TRN> traceNumber) {
        this.traceNumber = traceNumber;
    }

    public NM1 getName() {
        return name;
    }

    public void setName(NM1 name) {
        this.name = name;
    }

    public List<REF> getAdditionalIdentification() {
        return additionalIdentification;
    }

    public void setAdditionalIdentification(List<REF> additionalIdentification) {
        this.additionalIdentification = additionalIdentification;
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

    public DMG getDemographicInformation() {
        return demographicInformation;
    }

    public void setDemographicInformation(DMG demographicInformation) {
        this.demographicInformation = demographicInformation;
    }

    public INS getRelationship() {
        return relationship;
    }

    public void setRelationship(INS relationship) {
        this.relationship = relationship;
    }

    public HI getHealthCareDiagnosisCode() {
        return healthCareDiagnosisCode;
    }

    public void setHealthCareDiagnosisCode(HI healthCareDiagnosisCode) {
        this.healthCareDiagnosisCode = healthCareDiagnosisCode;
    }

    public List<DTP> getDate() {
        return date;
    }

    public void setDate(List<DTP> date) {
        this.date = date;
    }

    public List<BenefitInquiryDependentEligibility> getDependentEligibility() {
        return dependentEligibility;
    }
    public void setDependentEligibility(List<BenefitInquiryDependentEligibility> dependentEligibility) {
        this.dependentEligibility = dependentEligibility;
    }
}
