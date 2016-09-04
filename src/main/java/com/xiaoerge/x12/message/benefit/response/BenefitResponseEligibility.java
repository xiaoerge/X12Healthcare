package com.xiaoerge.x12.message.benefit.response;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.message.segment.*;
import com.xiaoerge.x12.util.SegmentStringUtil;
import com.xiaoerge.x12.util.StringQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitResponseEligibility extends MessageBase {

    private EB eligibility;
    private List<HSD> healthCareServiceDeliveries;
    private List<REF> additionalInformations;
    private List<DTP> eligibilityDates;
    private List<AAA> requestValidations;
    private List<MSG> messageTexts;
    private List<III> additionalEligibilities;

    private LS loopHeader;
    private List<BenefitResponseBenefitRelatedEntity> relatedEntities;
    private LE loopTrailer;

    public BenefitResponseEligibility() {
        eligibility = new EB();
        healthCareServiceDeliveries = new ArrayList<HSD>();
        additionalInformations = new ArrayList<REF>();
        eligibilityDates = new ArrayList<DTP>();
        requestValidations = new ArrayList<AAA>();
        messageTexts = new ArrayList<MSG>();
        additionalEligibilities = new ArrayList<III>();
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
            healthCareServiceDeliveries.add(new HSD(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            additionalInformations.add(new REF(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTP"))
            eligibilityDates.add(new DTP(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AAA"))
            requestValidations.add(new AAA(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("MSG"))
            messageTexts.add(new MSG(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("III"))
            additionalEligibilities.add(new III(stringQueue.getNext()));

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("LS"))
            loopHeader = new LS(stringQueue.getNext());

        //build string upto trailer
        StringBuilder relatedEntityBuilder = new StringBuilder();
        while(stringQueue.hasNext() && !stringQueue.peekNext().startsWith("LE")) {
            relatedEntityBuilder.append(stringQueue.getNext());
        }

        String[] splitArray = SegmentStringUtil.split(relatedEntityBuilder.toString(), "NM1");
        for (String relatedStr : splitArray) {
            relatedEntities.add(new BenefitResponseBenefitRelatedEntity(relatedStr));
        }

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("LE"))
            loopTrailer = new LE(stringQueue.getNext());

        if (stringQueue.hasNext()) {
            logger.warn(String.format("Unexpected string (%s) in %s",
                    stringQueue.hasNext(), this.getClass().getName()));
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(eligibility);
        messagesDefinition.addAll(healthCareServiceDeliveries);
        messagesDefinition.addAll(additionalInformations);
        messagesDefinition.addAll(eligibilityDates);
        messagesDefinition.addAll(requestValidations);
        messagesDefinition.addAll(messageTexts);
        messagesDefinition.addAll(additionalEligibilities);
        messagesDefinition.add(loopHeader);
        messagesDefinition.addAll(relatedEntities);
        messagesDefinition.add(loopTrailer);
    }

    public EB getEligibility() {
        return eligibility;
    }

    public void setEligibility(EB eligibility) {
        this.eligibility = eligibility;
    }

    public List<HSD> getHealthCareServiceDeliveries() {
        return healthCareServiceDeliveries;
    }

    public void setHealthCareServiceDeliveries(List<HSD> healthCareServiceDeliveries) {
        this.healthCareServiceDeliveries = healthCareServiceDeliveries;
    }

    public List<REF> getAdditionalInformations() {
        return additionalInformations;
    }

    public void setAdditionalInformations(List<REF> additionalInformations) {
        this.additionalInformations = additionalInformations;
    }

    public List<DTP> getEligibilityDates() {
        return eligibilityDates;
    }

    public void setEligibilityDates(List<DTP> eligibilityDates) {
        this.eligibilityDates = eligibilityDates;
    }

    public List<AAA> getRequestValidations() {
        return requestValidations;
    }

    public void setRequestValidations(List<AAA> requestValidations) {
        this.requestValidations = requestValidations;
    }

    public List<MSG> getMessageTexts() {
        return messageTexts;
    }

    public void setMessageTexts(List<MSG> messageTexts) {
        this.messageTexts = messageTexts;
    }

    public List<III> getAdditionalEligibilities() {
        return additionalEligibilities;
    }

    public void setAdditionalEligibilities(List<III> additionalEligibilities) {
        this.additionalEligibilities = additionalEligibilities;
    }

    public LS getLoopHeader() {
        return loopHeader;
    }

    public void setLoopHeader(LS loopHeader) {
        this.loopHeader = loopHeader;
    }

    public List<BenefitResponseBenefitRelatedEntity> getRelatedEntities() {
        return relatedEntities;
    }

    public void setRelatedEntities(List<BenefitResponseBenefitRelatedEntity> relatedEntities) {
        this.relatedEntities = relatedEntities;
    }

    public LE getLoopTrailer() {
        return loopTrailer;
    }

    public void setLoopTrailer(LE loopTrailer) {
        this.loopTrailer = loopTrailer;
    }
}
