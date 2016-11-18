package com.xiaoerge.x12.message.benefit.inquiry;

import com.xiaoerge.x12.message.segment.HL;
import com.xiaoerge.x12.message.segment.NM1;
import com.xiaoerge.x12.util.StringQueue;
import com.xiaoerge.x12.message.MessageLoopBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class BenefitInquiryInformationSource extends MessageLoopBase {
    private HL hierarchicalLevel;
    private NM1 individualOrOrganizationalName;

    List<BenefitInquiryInformationReceiver> benefitInquiryInformationReceivers;

    public BenefitInquiryInformationSource() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
        benefitInquiryInformationReceivers = new ArrayList<BenefitInquiryInformationReceiver>();
    }

    public BenefitInquiryInformationSource(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HL"))
            hierarchicalLevel = new HL(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            individualOrOrganizationalName = new NM1(stringQueue.getNext());

        //todo multiple receivers

        //find inquiry receiver
        StringBuilder receiverString = new StringBuilder();
        while (stringQueue.hasNext()) {
            receiverString.append(stringQueue.getNext());
        }
        benefitInquiryInformationReceivers.add(new BenefitInquiryInformationReceiver(receiverString.toString()));
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(hierarchicalLevel);
        messagesDefinition.add(individualOrOrganizationalName);
        messagesDefinition.addAll(benefitInquiryInformationReceivers);
    }

    public HL getHierarchicalLevel() {
        return hierarchicalLevel;
    }

    public void setHierarchicalLevel(HL hierarchicalLevel) {
        this.hierarchicalLevel = hierarchicalLevel;
    }

    public NM1 getIndividualOrOrganizationalName() {
        return individualOrOrganizationalName;
    }

    public void setIndividualOrOrganizationalName(NM1 individualOrOrganizationalName) {
        this.individualOrOrganizationalName = individualOrOrganizationalName;
    }

    public List<BenefitInquiryInformationReceiver> getBenefitInquiryInformationReceivers() {
        return benefitInquiryInformationReceivers;
    }

    public void setBenefitInquiryInformationReceivers(List<BenefitInquiryInformationReceiver> benefitInquiryInformationReceivers) {
        this.benefitInquiryInformationReceivers = benefitInquiryInformationReceivers;
    }
}
