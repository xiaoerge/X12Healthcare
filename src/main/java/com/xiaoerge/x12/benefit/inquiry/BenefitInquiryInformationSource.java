package com.xiaoerge.x12.benefit.inquiry;

import com.xiaoerge.x12.segment.HL;
import com.xiaoerge.x12.segment.NM1;
import com.xiaoerge.x12.util.StringQueue;
import com.xiaoerge.x12.message.MessageBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class BenefitInquiryInformationSource extends MessageBase {
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

    //todo remove these
    public String getHierarchicalIDNumber() { return hierarchicalLevel.getHierarchicalIDNumber(); }
    public String getHierarchicalLevelCode() { return hierarchicalLevel.getHierarchicalLevelCode(); }
    public String getHierarchicalChildCode() { return hierarchicalLevel.getHierarchicalChildCode(); }

    public String getEntityIdentifierCode() { return individualOrOrganizationalName.getEntityIdentifierCode(); }
    public String getEntityTypeQualifier() { return individualOrOrganizationalName.getEntityTypeQualifier(); }
    public String getNameLastOrOrganizationName() { return individualOrOrganizationalName.getNameLastOrOrganizationName(); }
    public String getNameFirst() { return individualOrOrganizationalName.getNameFirst(); }
    public String getNameMiddle() { return individualOrOrganizationalName.getNameMiddle(); }
    public String getNameSuffix() { return individualOrOrganizationalName.getNameSuffix(); }
    public String getIdentificationCodeQualifier() { return individualOrOrganizationalName.getIdentificationCodeQualifier(); }
    public String getIdentificationCode() { return individualOrOrganizationalName.getIdentificationCode(); }

    public void setHierarchicalIDNumber(String s) { hierarchicalLevel.setHierarchicalIDNumber(s); }
    public void setHierarchicalLevelCode(String s) { hierarchicalLevel.setHierarchicalLevelCode(s); }
    public void setHierarchicalChildCode(String s) { hierarchicalLevel.setHierarchicalChildCode(s); }

    public void setEntityIdentifierCode(String s) { individualOrOrganizationalName.setEntityIdentifierCode(s); }
    public void setEntityTypeQualifier(String s) { individualOrOrganizationalName.setEntityTypeQualifier(s); }
    public void setNameLastOrOrganizationName(String s) { individualOrOrganizationalName.setNameLastOrOrganizationName(s); }
    public void setNameFirst(String s) { individualOrOrganizationalName.setNameFirst(s); }
    public void setNameMiddle(String s) { individualOrOrganizationalName.setNameMiddle(s); }
    public void setNameSuffix(String s) { individualOrOrganizationalName.setNameSuffix(s); }
    public void setIdentificationCodeQualifier(String s) { individualOrOrganizationalName.setIdentificationCodeQualifier(s); }
    public void setIdentificationCode(String s) { individualOrOrganizationalName.setIdentificationCode(s); }

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
