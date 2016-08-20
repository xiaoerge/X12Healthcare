package com.xiaoerge.x12.benefit.inquiry;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.util.StringQueue;
import com.xiaoerge.x12.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class BenefitInquiryInformationReceiver extends MessageBase {
    private HL hierarchicalLevel;
    private NM1 individualOrOrganizationalName;
    private List<REF> referenceInformations;
    private N3 partyLocation;
    private N4 geographicLocation;
    private PRV providerInformation;

    private List<BenefitInquirySubscriber> benefitSubscribers;

    public BenefitInquiryInformationReceiver() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
        referenceInformations = new ArrayList<REF>();
        partyLocation = new N3();
        geographicLocation = new N4();
        providerInformation = new PRV();
        benefitSubscribers = new ArrayList<BenefitInquirySubscriber>();
    }

    public BenefitInquiryInformationReceiver(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("HL"))
            hierarchicalLevel = new HL(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            individualOrOrganizationalName = new NM1(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            referenceInformations.add(new REF(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N3"))
            partyLocation = new N3(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N4"))
            geographicLocation = new N4(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PRV"))
            providerInformation = new PRV(stringQueue.getNext());

        //todo multiple subscribers

        //find inquiry receiver
        StringBuilder stringBuilder = new StringBuilder();
        while (stringQueue.hasNext()) {
            stringBuilder.append(stringQueue.getNext());
        }
        benefitSubscribers.add(new BenefitInquirySubscriber(stringBuilder.toString()));
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(hierarchicalLevel);
        messagesDefinition.add(individualOrOrganizationalName);
        messagesDefinition.addAll(referenceInformations);
        messagesDefinition.add(partyLocation);
        messagesDefinition.add(geographicLocation);
        messagesDefinition.add(providerInformation);
        messagesDefinition.addAll(benefitSubscribers);
    }

    public String getHierarchicalIDNumber() { return hierarchicalLevel.getHierarchicalIDNumber(); }
    public String getHierarchicalParentIDNumber() { return hierarchicalLevel.getHierarchicalParentIDNumber(); }
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

//    public String getReferenceIdentificationQualifier() { return referenceInformations.getReferenceIdentificationQualifier(); }
//    public String getReferenceIdentification() { return referenceInformations.getReferenceIdentification(); }
//    public String getDescription() { return referenceInformations.getDescription(); }

    public String getCityName() { return geographicLocation.getCityName(); }
    public String getStateOrProvinceCode() { return geographicLocation.getStateOrProvinceCode(); }
    public String getPostalCode() { return geographicLocation.getPostalCode(); }
    public String getCountryCode() { return geographicLocation.getCountryCode(); }
    public String getCountrySubdivisionCode() { return geographicLocation.getCountrySubdivisionCode(); }

    public String getAddressInformation1() { return partyLocation.getAddressInformation1(); }
    public String getAddressInformation2() { return partyLocation.getAddressInformation2(); }

    public String getProviderCode() { return providerInformation.getProviderCode(); }
    public String getProviderReferenceIdentificationQualifier() { return providerInformation.getReferenceIdentificationQualifier(); }
    public String getProviderReferenceIdentification() { return providerInformation.getReferenceIdentification(); }

    public void setHierarchicalIDNumber(String s) { hierarchicalLevel.setHierarchicalIDNumber(s); }
    public void setHierarchicalParentIDNumber(String s) { hierarchicalLevel.setHierarchicalParentIDNumber(s); }
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

//    public void setReferenceIdentificationQualifier(String s) { referenceInformations.setReferenceIdentificationQualifier(s); }
//    public void setReferenceIdentification(String s) { referenceInformations.setReferenceIdentification(s); }
//    public void setDescription(String s) { referenceInformations.setDescription(s); }

    public void setCityName(String s) { geographicLocation.setCityName(s); }
    public void setStateOrProvinceCode(String s) { geographicLocation.setStateOrProvinceCode(s); }
    public void setPostalCode(String s) { geographicLocation.setPostalCode(s); }
    public void setCountryCode(String s) { geographicLocation.setCountryCode(s); }
    public void setCountrySubdivisionCode(String s) { geographicLocation.setCountrySubdivisionCode(s); }

    public void setAddressInformation1(String s) { partyLocation.setAddressInformation1(s); }
    public void setAddressInformation2(String s) { partyLocation.setAddressInformation2(s); }

    public void setProviderCode(String s) { providerInformation.setProviderCode(s); }
    public void setProviderReferenceIdentificationQualifier(String s) { providerInformation.setReferenceIdentificationQualifier(s); }
    public void setProviderReferenceIdentification(String s) { providerInformation.setReferenceIdentification(s); }
}
