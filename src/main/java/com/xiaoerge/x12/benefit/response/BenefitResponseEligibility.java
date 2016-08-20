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
public class BenefitResponseEligibility extends MessageBase {

    private EB eligibility;
    private List<HSD> healthCareServiceDelivery;
    private List<REF> additionalInformation;
    private List<DTP> eligibilityDate;
    private List<AAA> requestValidation;
    private List<MSG> messageText;
    private List<III> additionalEligibility;

    private LS loopHeader;
    private List<BenefitResponseBenefitRelatedEntity> relatedEntities;
    private LE loopTrailer;

    public BenefitResponseEligibility() {
        eligibility = new EB();
        healthCareServiceDelivery = new ArrayList<HSD>();
        additionalInformation = new ArrayList<REF>();
        eligibilityDate = new ArrayList<DTP>();
        requestValidation = new ArrayList<AAA>();
        messageText = new ArrayList<MSG>();
        additionalEligibility = new ArrayList<III>();
        loopHeader = new LS();
        relatedEntities = new ArrayList<BenefitResponseBenefitRelatedEntity>();
        loopTrailer = new LE();
    }
    public BenefitResponseEligibility(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("EB"))
            eligibility = new EB(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HSD"))
            healthCareServiceDelivery.add(new HSD(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalInformation.add(new REF(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            eligibilityDate.add(new DTP(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AAA"))
            requestValidation.add(new AAA(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("MSG"))
            messageText.add(new MSG(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("III"))
            additionalEligibility.add(new III(stringQueue.getNext()));

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("LS"))
            loopHeader = new LS(stringQueue.getNext());

        //build string upto trailer
        StringBuilder relatedEntityBuilder = new StringBuilder();
        while(stringQueue.hasNext() && !stringQueue.peekNext().equals("LE")) {
            relatedEntityBuilder.append(stringQueue.getNext());
        }

        String[] splitArray = SegmentStringUtil.split(relatedEntityBuilder.toString(), "NM1");
        for (String relatedStr : splitArray) {
            relatedEntities.add(new BenefitResponseBenefitRelatedEntity(relatedStr));
        }

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("LE"))
            loopTrailer = new LE(stringQueue.getNext());

        if (stringQueue.hasNext()) {
            logger.warn("Unexpected string in "+this.getClass().getName());
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(eligibility);
        messagesDefinition.addAll(healthCareServiceDelivery);
        messagesDefinition.addAll(additionalInformation);
        messagesDefinition.addAll(eligibilityDate);
        messagesDefinition.addAll(requestValidation);
        messagesDefinition.addAll(messageText);
        messagesDefinition.addAll(additionalEligibility);
        messagesDefinition.add(loopHeader);
        messagesDefinition.addAll(relatedEntities);
        messagesDefinition.add(loopTrailer);
    }
}
