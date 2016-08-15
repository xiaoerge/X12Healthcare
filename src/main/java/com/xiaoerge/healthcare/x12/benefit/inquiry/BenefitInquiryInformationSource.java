package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.segment.HL;
import com.xiaoerge.healthcare.x12.segment.NM1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class BenefitInquiryInformationSource extends IMessage {
    private HL hierarchicalLevel;
    private NM1 individualOrOrganizationalName;

    List<BenefitInformationReceiver> benefitInformationReceivers;

    public BenefitInquiryInformationSource() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
        benefitInformationReceivers = new ArrayList<BenefitInformationReceiver>();
    }

    public BenefitInquiryInformationSource(String s) {
        StringQueue stringQueue = new StringQueue(s);
        StringBuilder stringBuilder = new StringBuilder();

        hierarchicalLevel = new HL(stringQueue.getNext());
        individualOrOrganizationalName = new NM1(stringQueue.getNext());
        benefitInformationReceivers = new ArrayList<BenefitInformationReceiver>();

        while (stringQueue.hasNext()) {
            String peek = stringQueue.peekNext();
            String next = stringQueue.getNext();

            if (peek.startsWith("HL") &&
                    new HL(peek).getHierarchicalParentIDNumber().equals(hierarchicalLevel.getHierarchicalParentIDNumber())
                    && stringBuilder.length() > 0) {
                stringBuilder.append(next);

                BenefitInformationReceiver receiver = new BenefitInformationReceiver(stringBuilder.toString());
                benefitInformationReceivers.add(receiver);
                stringBuilder = new StringBuilder();

                logger.info("Start hierarchical level "+ next);
            }
            else {
                stringBuilder.append(next);
                logger.info("Found segment "+ next);
            }
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(hierarchicalLevel);
        messagesDefinition.add(individualOrOrganizationalName);
        messagesDefinition.addAll(benefitInformationReceivers);
    }

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
}
