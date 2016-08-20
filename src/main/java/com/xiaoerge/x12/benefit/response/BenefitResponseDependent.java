package com.xiaoerge.x12.benefit.response;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.util.SegmentStringUtil;
import com.xiaoerge.x12.util.StringQueue;
import com.xiaoerge.x12.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/11/16.
 */
public class BenefitResponseDependent extends MessageBase {
    private HL dependentLevel;
    private List<TRN> dependentTraces;
    private NM1 dependentName;
    private List<REF> additionalIdentification;
    private N3 dependentAddress;
    private N4 dependentCityState;
    private List<AAA> dependentRequestValidation;
    private PRV providerInformation;
    private DMG dependentDemographic;
    private INS dependentRelationship;
    private HI dependentHealthCareDiagnosisCode;
    private List<DTP> dependentDate;
    private MPI dependentMilitaryPersonnelInformation;

    private List<BenefitResponseEligibility> dependentEligibility;

    public BenefitResponseDependent() {
        dependentLevel = new HL();
        dependentTraces = new ArrayList<TRN>();
        dependentName = new NM1();
        additionalIdentification = new ArrayList<REF>();
        dependentAddress = new N3();
        dependentCityState = new N4();
        dependentRequestValidation = new ArrayList<AAA>();
        providerInformation = new PRV();
        dependentDemographic = new DMG();
        dependentRelationship = new INS();
        dependentHealthCareDiagnosisCode = new HI();
        dependentDate = new ArrayList<DTP>();
        dependentMilitaryPersonnelInformation = new MPI();
        dependentEligibility = new ArrayList<BenefitResponseEligibility>();
    }
    public BenefitResponseDependent(String s) {
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
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AAA"))
            dependentRequestValidation.add(new AAA(stringQueue.getNext()));
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
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("MPI"))
            dependentMilitaryPersonnelInformation = new MPI(stringQueue.getNext());

        StringBuilder builder = new StringBuilder();
        while (stringQueue.hasNext()) {
            builder.append(stringQueue.getNext());
        }

        String[] splitArray = SegmentStringUtil.split(builder.toString(), "EB");
        for(String str : splitArray) {
            dependentEligibility.add(new BenefitResponseEligibility(str));
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(dependentLevel);
        messagesDefinition.addAll(dependentTraces);
        messagesDefinition.add(dependentName);
        messagesDefinition.addAll(additionalIdentification);
        messagesDefinition.add(dependentAddress);
        messagesDefinition.add(dependentCityState);
        messagesDefinition.addAll(dependentRequestValidation);
        messagesDefinition.add(providerInformation);
        messagesDefinition.add(dependentDemographic);
        messagesDefinition.add(dependentRelationship);
        messagesDefinition.add(dependentHealthCareDiagnosisCode);
        messagesDefinition.addAll(dependentDate);
        messagesDefinition.add(dependentMilitaryPersonnelInformation);
        messagesDefinition.addAll(dependentEligibility);
    }
}
