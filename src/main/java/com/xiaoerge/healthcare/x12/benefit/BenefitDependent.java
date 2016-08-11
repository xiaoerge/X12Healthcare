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
    private DTP dependentDate;
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
        dependentDate = new DTP();
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
        messagesDefinition.add(dependentDate);
        messagesDefinition.add(dependentEligibility);
        messagesDefinition.add(dependentAdditionalEligibility);
        messagesDefinition.add(dependentAdditionalInformation);
        messagesDefinition.add(dependentEligibilityDate);
    }
    public BenefitDependent(String s) {
        this();
        StringBuilder stringBuilder = new StringBuilder();
        StringQueue stringQueue = new StringQueue(s);

        dependentLevel = new HL(stringQueue.getNext());

        while (stringQueue.hasNext()) {
            String peek = stringQueue.peekNext();
            String next = stringQueue.getNext();
            if (peek.startsWith("HL") && new HL(peek).getHierarchicalParentIDNumber().equals(dependentLevel.getHierarchicalIDNumber())) {

                //todo does not work yet
                stringBuilder = new StringBuilder();

                logger.info("Start hierarchical level "+ next);
            }
            if (next.startsWith("TRN")) {
                dependentTraces.add(new TRN(next));
                logger.info("Found TRN segment "+ next);
            }
            else if (next.startsWith("NM1")) {
                dependentName = new NM1(next);
                logger.info("Found NM1 segment "+ next);
            }
            else if (next.startsWith("REF")) {
                additionalIdentification.add(new REF(next));
                logger.info("Found REF segment "+ next);
            }
            else if (next.startsWith("N3")) {
                dependentAddress = new N3(next);
                logger.info("Found N3 segment "+ next);
            }
            else if (next.startsWith("N4")) {
                dependentCityState = new N4(next);
                logger.info("Found N4 segment "+ next);
            }
            else if (next.startsWith("PRV")) {
                providerInformation = new PRV(next);
                logger.info("Found PRV segment "+ next);
            }

            else if (next.startsWith("DMG")) {
                dependentDemographic = new DMG(next);
            }
            else if (next.startsWith("INS")) {
                dependentRelationship = new INS(next);
            }
            else if (next.startsWith("HI")) {
                dependentHealthCareDiagnosisCode = new HI(next);
            }
            else if (next.startsWith("DTP")) {
                dependentDate = new DTP(next);
            }
            else if (next.startsWith("EQ")) {
                dependentEligibility = new EQ(next);
            }
            else if (next.startsWith("III")) {
                dependentAdditionalEligibility = new III(next);
                logger.info("Found PRV segment "+ next);
            }
            else if (next.startsWith("REF")) {
                dependentAdditionalInformation = new REF(next);
                logger.info("Found PRV segment "+ next);
            }
            else if (next.startsWith("DTP")) {
                dependentEligibilityDate = new DTP(next);
                logger.info("Found PRV segment "+ next);
            }

            else {
                stringBuilder.append(next);
                logger.info("Found segment "+ next);
            }
        }
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
}
