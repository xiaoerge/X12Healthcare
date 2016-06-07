package com.xiaoerge.healthcare.x12.loop;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.*;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class InformationReceiver implements IMessage {

    private HL hierarchicalLevel;
    private NM1 individualOrOrganizationalName;
    private REF referenceInformation;
    private N3 partyLocation;
    private N4 geographicLocation;
    private PRV providerInformation;

    public InformationReceiver() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
        referenceInformation = new REF();
        partyLocation = new N3();
        geographicLocation = new N4();
        providerInformation = new PRV();
    }

    public InformationReceiver(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        hierarchicalLevel = new HL(stringQueue.getNext());
        individualOrOrganizationalName = new NM1(stringQueue.getNext());

        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("REF")) {
                referenceInformation = new REF(next);
            }
            else if (next.startsWith("N3")) {
                partyLocation = new N3(next);
            }
            else if (next.startsWith("N4")) {
                geographicLocation = new N4(next);
            }
            else if (next.startsWith("PRV")) {
                providerInformation = new PRV(next);
            }
        }
    }

    public boolean validate() {
        return hierarchicalLevel.validate()
                && individualOrOrganizationalName.validate()
                && referenceInformation.validate()
                && partyLocation.validate()
                && geographicLocation.validate()
                && providerInformation.validate();
    }

    public String toX12String() {
        return hierarchicalLevel.toX12String()
                +individualOrOrganizationalName.toX12String()
                +referenceInformation.toX12String()
                +partyLocation.toX12String()
                +geographicLocation.toX12String();
    }

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

    public String getReferenceIdentificationQualifier() { return referenceInformation.getReferenceIdentificationQualifier(); }
    public String getReferenceIdentification() { return referenceInformation.getReferenceIdentification(); }
    public String getDescription() { return referenceInformation.getDescription(); }

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

    public void setReferenceIdentificationQualifier(String s) { referenceInformation.setReferenceIdentificationQualifier(s); }
    public void setReferenceIdentification(String s) { referenceInformation.setReferenceIdentification(s); }
    public void setDescription(String s) { referenceInformation.setDescription(s); }

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
