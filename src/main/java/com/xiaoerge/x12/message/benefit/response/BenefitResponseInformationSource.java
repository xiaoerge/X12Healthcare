package com.xiaoerge.x12.message.benefit.response;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.message.segment.AAA;
import com.xiaoerge.x12.message.segment.HL;
import com.xiaoerge.x12.message.segment.NM1;
import com.xiaoerge.x12.message.segment.PER;
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
        requestValidation = new ArrayList<AAA>();
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
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AAA"))
            requestValidation.add(new AAA(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            individualOrOrganizationalName = new NM1(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PER"))
            contactInformation.add(new PER(stringQueue.getNext()));
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("AAA"))
            requestValidation2.add(new AAA(stringQueue.getNext()));

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
        messagesDefinition.addAll(requestValidation);
        messagesDefinition.add(individualOrOrganizationalName);
        messagesDefinition.addAll(contactInformation);
        messagesDefinition.addAll(requestValidation2);
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
