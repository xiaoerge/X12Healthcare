package com.xiaoerge.healthcare.x12.loop;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.HL;
import com.xiaoerge.healthcare.x12.segment.NM1;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class BenefitInformationSource implements IMessage {

    private HL hierarchicalLevel;
    private NM1 individualOrOrganizationalName;

    public BenefitInformationSource() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
    }

    public BenefitInformationSource(String s) {
        StringQueue stringQueue = new StringQueue(s);

        hierarchicalLevel = new HL(stringQueue.getNext());
        individualOrOrganizationalName = new NM1(stringQueue.getNext());
    }

    public boolean validate() {
        return hierarchicalLevel.validate() && individualOrOrganizationalName.validate();
    }

    public String toX12String() {
        return hierarchicalLevel.toX12String()+individualOrOrganizationalName.toX12String();
    }

    public boolean isEmpty() {
        return hierarchicalLevel.isEmpty() && individualOrOrganizationalName.isEmpty();
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
