package com.xiaoerge.healthcare.x12.benefit;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.segment.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class BenefitInformationReceiver implements IMessage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private HL hierarchicalLevel;
    private NM1 individualOrOrganizationalName;
    private List<REF> referenceInformation;
    private N3 partyLocation;
    private N4 geographicLocation;
    private PRV providerInformation;

    private List<BenefitSubscriber> benefitSubscribers;

    public BenefitInformationReceiver() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
        referenceInformation = new ArrayList<REF>();
        partyLocation = new N3();
        geographicLocation = new N4();
        providerInformation = new PRV();
        benefitSubscribers = new ArrayList<BenefitSubscriber>();
    }

    public BenefitInformationReceiver(String s) {
        this();
        StringBuilder stringBuilder = new StringBuilder();
        StringQueue stringQueue = new StringQueue(s);

        hierarchicalLevel = new HL(stringQueue.getNext());
        individualOrOrganizationalName = new NM1(stringQueue.getNext());

        while (stringQueue.hasNext()) {
            String peek = stringQueue.peekNext();
            String next = stringQueue.getNext();
            if (peek.startsWith("HL") &&
                    new HL(peek).getHierarchicalParentIDNumber().equals(hierarchicalLevel.getHierarchicalParentIDNumber())
                    && stringBuilder.length() > 0) {

                BenefitSubscriber subscriber = new BenefitSubscriber(stringBuilder.toString());
                benefitSubscribers.add(subscriber);
                stringBuilder = new StringBuilder();

                logger.info("Start hierarchical level "+ next);
            }
            if (next.startsWith("REF")) {
                referenceInformation.add(new REF(next));
                logger.info("Found REF segment "+ next);
            }
            else if (next.startsWith("N3")) {
                partyLocation = new N3(next);
                logger.info("Found N3 segment "+ next);
            }
            else if (next.startsWith("N4")) {
                geographicLocation = new N4(next);
                logger.info("Found N4 segment "+ next);
            }
            else if (next.startsWith("PRV")) {
                providerInformation = new PRV(next);
                logger.info("Found PRV segment "+ next);
            }
            else {
                stringBuilder.append(next);
                logger.info("Found segment "+ next);
            }
        }
    }

    public boolean validate() {
        boolean refValidate = true;
        for (REF ref : referenceInformation) if (!ref.validate()) refValidate = false;

        return hierarchicalLevel.validate()
                && individualOrOrganizationalName.validate()
                && refValidate
                && partyLocation.validate()
                && geographicLocation.validate()
                && providerInformation.validate();
    }

    public String toX12String() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hierarchicalLevel.toX12String());
        stringBuilder.append(individualOrOrganizationalName.toX12String());
        for (REF ref : referenceInformation) stringBuilder.append(ref.toX12String());

        stringBuilder.append(partyLocation.toX12String());
        stringBuilder.append(geographicLocation.toX12String());
        stringBuilder.append(providerInformation.toX12String());

        for (BenefitSubscriber subscriber : benefitSubscribers) stringBuilder.append(subscriber.toX12String());

        return stringBuilder.toString();
    }

    public String toString() {return toX12String();}

    public boolean isEmpty() {
        return false;
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

//    public String getReferenceIdentificationQualifier() { return referenceInformation.getReferenceIdentificationQualifier(); }
//    public String getReferenceIdentification() { return referenceInformation.getReferenceIdentification(); }
//    public String getDescription() { return referenceInformation.getDescription(); }

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

//    public void setReferenceIdentificationQualifier(String s) { referenceInformation.setReferenceIdentificationQualifier(s); }
//    public void setReferenceIdentification(String s) { referenceInformation.setReferenceIdentification(s); }
//    public void setDescription(String s) { referenceInformation.setDescription(s); }

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
