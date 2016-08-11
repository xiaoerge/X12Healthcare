package com.xiaoerge.healthcare.x12.benefit;

import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.segment.*;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitDependent implements IMessage {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private final List<IMessage> messagesDefinition = new ArrayList<IMessage>();

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
    private EQ dependentEligibility;
    private III dependentAdditionalEligibility;
    private REF dependentAdditionalInformation;
    private DTP dependentEligibilityDate;

    public BenefitDependent() {
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
        dependentEligibility = new EQ();
        dependentAdditionalEligibility = new III();
        dependentAdditionalInformation = new REF();
        dependentEligibilityDate = new DTP();

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
        messagesDefinition.add(dependentEligibility);
        messagesDefinition.add(dependentAdditionalEligibility);
        messagesDefinition.add(dependentAdditionalInformation);
        messagesDefinition.add(dependentEligibilityDate);
    }
    public BenefitDependent(String s) {
        this();
        StringBuilder stringBuilder = new StringBuilder();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.peekNext().equals("HL")) dependentLevel = new HL(stringQueue.getNext());
        while (stringQueue.peekNext().equals("TRN")) dependentTraces.add(new TRN(stringQueue.getNext()));
        if (stringQueue.peekNext().equals("NM1")) dependentName = new NM1(stringQueue.getNext());
        while (stringQueue.peekNext().equals("REF")) additionalIdentification.add(new REF(stringQueue.getNext()));
        if (stringQueue.peekNext().equals("N3")) dependentAddress = new N3(stringQueue.getNext());
        if (stringQueue.peekNext().equals("N4")) dependentCityState = new N4(stringQueue.getNext());
        if (stringQueue.peekNext().equals("PRV")) providerInformation = new PRV(stringQueue.getNext());
        if (stringQueue.peekNext().equals("DMG")) dependentDemographic = new DMG(stringQueue.getNext());
        if (stringQueue.peekNext().equals("INS")) dependentRelationship = new INS(stringQueue.getNext());
        if (stringQueue.peekNext().equals("HI")) dependentHealthCareDiagnosisCode = new HI(stringQueue.getNext());
        while (stringQueue.peekNext().equals("DTP")) dependentDate.add(new DTP(stringQueue.getNext()));

        //todo benefit dependent eligibility loop 2110D
    }

    public boolean validate() {
        for (IMessage message : messagesDefinition) {
            if (!message.validate()) return false;
        }
        return true;
    }

    public String toX12String() {
        StringBuilder stringBuilder = new StringBuilder();

        for (IMessage message : messagesDefinition) {
            stringBuilder.append(message.toX12String());
        }

        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        for (IMessage message : messagesDefinition) {
            if (!message.isEmpty()) return false;
        }
        return true;
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

    public EQ getDependentEligibility() {
        return dependentEligibility;
    }

    public void setDependentEligibility(EQ dependentEligibility) {
        this.dependentEligibility = dependentEligibility;
    }

    public III getDependentAdditionalEligibility() {
        return dependentAdditionalEligibility;
    }

    public void setDependentAdditionalEligibility(III dependentAdditionalEligibility) {
        this.dependentAdditionalEligibility = dependentAdditionalEligibility;
    }

    public REF getDependentAdditionalInformation() {
        return dependentAdditionalInformation;
    }

    public void setDependentAdditionalInformation(REF dependentAdditionalInformation) {
        this.dependentAdditionalInformation = dependentAdditionalInformation;
    }

    public DTP getDependentEligibilityDate() {
        return dependentEligibilityDate;
    }

    public void setDependentEligibilityDate(DTP dependentEligibilityDate) {
        this.dependentEligibilityDate = dependentEligibilityDate;
    }
}
