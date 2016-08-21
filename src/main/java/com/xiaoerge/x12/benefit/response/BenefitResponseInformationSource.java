package com.xiaoerge.x12.benefit.response;

import com.xiaoerge.x12.benefit.inquiry.BenefitInquiryInformationReceiver;
import com.xiaoerge.x12.message.BenefitResponse;
import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.segment.AAA;
import com.xiaoerge.x12.segment.HL;
import com.xiaoerge.x12.segment.NM1;
import com.xiaoerge.x12.segment.PER;
import com.xiaoerge.x12.util.StringQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class BenefitResponseInformationSource extends MessageBase {
    private HL hierarchicalLevel;
    private List<AAA> requestValidation;
    private NM1 individualOrOrganizationalName;
    private List<PER> contactInformation;
    private List<AAA> requestValidation2;

    List<BenefitResponseInformationReceiver> informationReceivers;

    public BenefitResponseInformationSource() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
        contactInformation = new ArrayList<PER>();
        requestValidation2 = new ArrayList<AAA>();
        informationReceivers = new ArrayList<BenefitResponseInformationReceiver>();
    }

    public BenefitResponseInformationSource(String s) {
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
        informationReceivers.add(new BenefitResponseInformationReceiver(receiverString.toString()));
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(hierarchicalLevel);
        messagesDefinition.add(individualOrOrganizationalName);
        messagesDefinition.addAll(informationReceivers);
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

    public List<BenefitResponseInformationReceiver> getInformationReceivers() {
        return informationReceivers;
    }

    public void setInformationReceivers(List<BenefitResponseInformationReceiver> informationReceivers) {
        this.informationReceivers = informationReceivers;
    }

    public List<AAA> getRequestValidation() {
        return requestValidation;
    }

    public void setRequestValidation(List<AAA> requestValidation) {
        this.requestValidation = requestValidation;
    }

    public List<PER> getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(List<PER> contactInformation) {
        this.contactInformation = contactInformation;
    }

    public List<AAA> getRequestValidation2() {
        return requestValidation2;
    }

    public void setRequestValidation2(List<AAA> requestValidation2) {
        this.requestValidation2 = requestValidation2;
    }
}
