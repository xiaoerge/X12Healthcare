package com.xiaoerge.x12.message.benefit.response;

import com.xiaoerge.x12.message.MessageLoopBase;
import com.xiaoerge.x12.message.segment.*;
import com.xiaoerge.x12.util.SegmentStringUtil;
import com.xiaoerge.x12.util.StringQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitResponseSubscriber extends MessageLoopBase {
    private HL hierarchicalLevel;
    private List<TRN> traceNumbers;
    private NM1 name;
    private List<REF> additionalIdentifications;
    private N3 address;
    private N4 cityStateZip;
    private List<AAA> requestValidations;
    private PRV providerInformation;
    private DMG demographic;
    private INS relationship;
    private HI healthCareDiagnosisCode;
    private List<DTP> dates;
    private MPI militaryPersonnelInformation;

    private List<BenefitResponseEligibility> eligibilities;
    private List<BenefitResponseDependent> dependents;

    public BenefitResponseSubscriber() {
        hierarchicalLevel = new HL();
        traceNumbers = new ArrayList<TRN>();
        name = new NM1();
        additionalIdentifications = new ArrayList<REF>();
        address = new N3();
        cityStateZip = new N4();
        requestValidations = new ArrayList<AAA>();
        providerInformation = new PRV();
        demographic = new DMG();
        relationship = new INS();
        healthCareDiagnosisCode = new HI();
        dates = new ArrayList<DTP>();
        militaryPersonnelInformation = new MPI();
        eligibilities = new ArrayList<BenefitResponseEligibility>();
        dependents = new ArrayList<BenefitResponseDependent>();
    }
    public BenefitResponseSubscriber(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HL"))
            hierarchicalLevel = new HL(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("TRN"))
            traceNumbers.add(new TRN(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            name = new NM1(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalIdentifications.add(new REF(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N3"))
            address = new N3(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N4"))
            cityStateZip = new N4(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AAA"))
            requestValidations.add(new AAA(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PRV"))
            providerInformation = new PRV(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DMG"))
            demographic = new DMG(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("INS"))
            relationship = new INS(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HI"))
            healthCareDiagnosisCode = new HI(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            dates.add(new DTP(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("MPI"))
            militaryPersonnelInformation = new MPI(stringQueue.getNext());

        StringBuilder builder = new StringBuilder();
        while (stringQueue.hasNext() && !stringQueue.peekNext().startsWith("HL")) {
            builder.append(stringQueue.getNext());
        }

        String[] splitArray = SegmentStringUtil.split(builder.toString(), "EB");
        for(String str : splitArray) {
            eligibilities.add(new BenefitResponseEligibility(str));
        }

        builder = new StringBuilder();
        while (stringQueue.hasNext()) {
            builder.append(stringQueue.getNext());
        }

        String[] dArray = SegmentStringUtil.split(builder.toString(), "HL");
        for (String str : dArray) {
            dependents.add(new BenefitResponseDependent(str));
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
        messagesDefinition.addAll(requestValidations);
        messagesDefinition.add(providerInformation);
        messagesDefinition.add(demographic);
        messagesDefinition.add(relationship);
        messagesDefinition.add(healthCareDiagnosisCode);
        messagesDefinition.addAll(dates);
        messagesDefinition.add(militaryPersonnelInformation);
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

    public List<AAA> getRequestValidations() {
        return requestValidations;
    }

    public void setRequestValidations(List<AAA> requestValidations) {
        this.requestValidations = requestValidations;
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

    public List<DTP> getDates() {
        return dates;
    }

    public void setDates(List<DTP> dates) {
        this.dates = dates;
    }

    public MPI getMilitaryPersonnelInformation() {
        return militaryPersonnelInformation;
    }

    public void setMilitaryPersonnelInformation(MPI militaryPersonnelInformation) {
        this.militaryPersonnelInformation = militaryPersonnelInformation;
    }

    public List<BenefitResponseEligibility> getEligibilities() {
        return eligibilities;
    }

    public void setEligibilities(List<BenefitResponseEligibility> eligibilities) {
        this.eligibilities = eligibilities;
    }

    public List<BenefitResponseDependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<BenefitResponseDependent> dependents) {
        this.dependents = dependents;
    }
}
