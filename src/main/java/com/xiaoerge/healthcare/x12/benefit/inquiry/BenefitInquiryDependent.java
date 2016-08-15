package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.message.MessageBase;
import com.xiaoerge.healthcare.x12.util.StringQueue;
import com.xiaoerge.healthcare.x12.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitInquiryDependent extends MessageBase {
    private HL dependentLevel;
    private List<TRN> dependentTraces;
    private NM1 dependentName;
    private List<REF> additionalIdentification;
    private N3 dependentAddress;
    private N4 dependentCityState;
    private PRV providerInformation;
    private DMG dependentDemographic;
    private INS dependentRelationship;
    private HI dependentHealthCareDiagnosisCode;
    private List<DTP> dependentDate;

    private List<BenefitInquiryDependentEligibility> dependentEligibility;

    public BenefitInquiryDependent() {
        dependentLevel = new HL();
        dependentTraces = new ArrayList<TRN>();
        dependentName = new NM1();
        additionalIdentification = new ArrayList<REF>();
        dependentAddress = new N3();
        dependentCityState = new N4();
        providerInformation = new PRV();
        dependentDemographic = new DMG();
        dependentRelationship = new INS();
        dependentHealthCareDiagnosisCode = new HI();
        dependentDate = new ArrayList<DTP>();
        dependentEligibility = new ArrayList<BenefitInquiryDependentEligibility>();
    }
    public BenefitInquiryDependent(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HL"))
            dependentLevel = new HL(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("TRN"))
            dependentTraces.add(new TRN(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            dependentName = new NM1(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalIdentification.add(new REF(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N3"))
            dependentAddress = new N3(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N4"))
            dependentCityState = new N4(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PRV"))
            providerInformation = new PRV(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DMG"))
            dependentDemographic = new DMG(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("INS"))
            dependentRelationship = new INS(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HI"))
            dependentHealthCareDiagnosisCode = new HI(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            dependentDate.add(new DTP(stringQueue.getNext()));

        StringBuilder benefitInquiryDependentEligibilityString = new StringBuilder();
        boolean isFirst = true;
        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();

            if (next.startsWith("EQ")) {
                if (isFirst) {
                    isFirst = false;
                }
                else {
                    dependentEligibility.add(new BenefitInquiryDependentEligibility(
                        benefitInquiryDependentEligibilityString.toString()));

                    benefitInquiryDependentEligibilityString = new StringBuilder();
                }
                benefitInquiryDependentEligibilityString.append(next);
            }
            else {
                benefitInquiryDependentEligibilityString.append(next);
            }
        }
        dependentEligibility.add(new BenefitInquiryDependentEligibility(
                benefitInquiryDependentEligibilityString.toString()));

    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(dependentLevel);
        messagesDefinition.addAll(dependentTraces);
        messagesDefinition.add(dependentName);
        messagesDefinition.addAll(additionalIdentification);
        messagesDefinition.add(dependentAddress);
        messagesDefinition.add(dependentCityState);
        messagesDefinition.add(providerInformation);
        messagesDefinition.add(dependentDemographic);
        messagesDefinition.add(dependentRelationship);
        messagesDefinition.add(dependentHealthCareDiagnosisCode);
        messagesDefinition.addAll(dependentDate);
        messagesDefinition.addAll(dependentEligibility);
    }


    public HL getDependentLevel() {
        return dependentLevel;
    }

    public void setDependentLevel(HL dependentLevel) {
        this.dependentLevel = dependentLevel;
    }

    public List<TRN> getDependentTraces() {
        return dependentTraces;
    }

    public void setDependentTraces(List<TRN> dependentTraces) {
        this.dependentTraces = dependentTraces;
    }

    public NM1 getDependentName() {
        return dependentName;
    }

    public void setDependentName(NM1 dependentName) {
        this.dependentName = dependentName;
    }

    public List<REF> getAdditionalIdentification() {
        return additionalIdentification;
    }

    public void setAdditionalIdentification(List<REF> additionalIdentification) {
        this.additionalIdentification = additionalIdentification;
    }

    public N3 getDependentAddress() {
        return dependentAddress;
    }

    public void setDependentAddress(N3 dependentAddress) {
        this.dependentAddress = dependentAddress;
    }

    public N4 getDependentCityState() {
        return dependentCityState;
    }

    public void setDependentCityState(N4 dependentCityState) {
        this.dependentCityState = dependentCityState;
    }

    public PRV getProviderInformation() {
        return providerInformation;
    }

    public void setProviderInformation(PRV providerInformation) {
        this.providerInformation = providerInformation;
    }

    public DMG getDependentDemographic() {
        return dependentDemographic;
    }

    public void setDependentDemographic(DMG dependentDemographic) {
        this.dependentDemographic = dependentDemographic;
    }

    public INS getDependentRelationship() {
        return dependentRelationship;
    }

    public void setDependentRelationship(INS dependentRelationship) {
        this.dependentRelationship = dependentRelationship;
    }

    public HI getDependentHealthCareDiagnosisCode() {
        return dependentHealthCareDiagnosisCode;
    }

    public void setDependentHealthCareDiagnosisCode(HI dependentHealthCareDiagnosisCode) {
        this.dependentHealthCareDiagnosisCode = dependentHealthCareDiagnosisCode;
    }

    public List<DTP> getDependentDate() {
        return dependentDate;
    }

    public void setDependentDate(List<DTP> dependentDate) {
        this.dependentDate = dependentDate;
    }

    public List<BenefitInquiryDependentEligibility> getDependentEligibility() {
        return dependentEligibility;
    }
    public void setDependentEligibility(List<BenefitInquiryDependentEligibility> dependentEligibility) {
        this.dependentEligibility = dependentEligibility;
    }
}
