package com.xiaoerge.x12.benefit.response;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.segment.*;
import com.xiaoerge.x12.util.SegmentStringUtil;
import com.xiaoerge.x12.util.StringQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitResponseDependentEligibility extends MessageBase {

    private EB dependentEligibility;
    private List<HSD> healthCareServiceDelivery;
    private List<REF> dependentAdditionalInformation;
    private List<DTP> dependentEligibilityDate;
    private List<AAA> dependentRequestValidation;
    private List<MSG> messageText;
    private List<III> dependentAdditionalEligibility;

    private LS loopHeader;
    private List<BenefitResponseDependentBenefitRelatedEntity> relatedEntities;
    private LE loopTrailer;

    public BenefitResponseDependentEligibility() {
        dependentEligibility = new EB();
        healthCareServiceDelivery = new ArrayList<HSD>();
        dependentAdditionalInformation = new ArrayList<REF>();
        dependentEligibilityDate = new ArrayList<DTP>();
        dependentRequestValidation = new ArrayList<AAA>();
        messageText = new ArrayList<MSG>();
        dependentAdditionalEligibility = new ArrayList<III>();
        loopHeader = new LS();
        relatedEntities = new ArrayList<BenefitResponseDependentBenefitRelatedEntity>();
        loopTrailer = new LE();
    }
    public BenefitResponseDependentEligibility(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("EB"))
            dependentEligibility = new EB(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HSD"))
            healthCareServiceDelivery.add(new HSD(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            dependentAdditionalInformation.add(new REF(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            dependentEligibilityDate.add(new DTP(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AAA"))
            dependentRequestValidation.add(new AAA(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("MSG"))
            messageText.add(new MSG(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("III"))
            dependentAdditionalEligibility.add(new III(stringQueue.getNext()));

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("LS"))
            loopHeader = new LS(stringQueue.getNext());

        //build string upto trailer
        StringBuilder relatedEntityBuilder = new StringBuilder();
        while(stringQueue.hasNext() && !stringQueue.peekNext().equals("LE")) {
            relatedEntityBuilder.append(stringQueue.getNext());
        }

        String[] splitArray = SegmentStringUtil.split(relatedEntityBuilder.toString(), "NM1");
        for (String relatedStr : splitArray) {
            relatedEntities.add(new BenefitResponseDependentBenefitRelatedEntity(relatedStr));
        }

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("LE"))
            loopTrailer = new LE(stringQueue.getNext());

        if (stringQueue.hasNext()) {
            logger.warn("Unexpected string in "+this.getClass().getName());
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(dependentEligibility);
        messagesDefinition.addAll(healthCareServiceDelivery);
        messagesDefinition.addAll(dependentAdditionalInformation);
        messagesDefinition.addAll(dependentEligibilityDate);
        messagesDefinition.addAll(dependentRequestValidation);
        messagesDefinition.addAll(messageText);
        messagesDefinition.addAll(dependentAdditionalEligibility);
        messagesDefinition.add(loopHeader);
        messagesDefinition.addAll(relatedEntities);
        messagesDefinition.add(loopTrailer);
    }
}
