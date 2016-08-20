package com.xiaoerge.x12.benefit.response;

import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.segment.*;
import com.xiaoerge.x12.util.StringQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 8/13/16.
 */
public class BenefitResponseDependentBenefitRelatedEntity extends MessageBase {

    private NM1 relatedEntityName;
    private N3 relatedEntityAddress;
    private N4 relatedEntityCityStateZip;
    private List<PER> relatedEntityContactInformation;
    private PRV relatedProviderInformation;

    public BenefitResponseDependentBenefitRelatedEntity() {
        relatedEntityName = new NM1();
        relatedEntityAddress = new N3();
        relatedEntityCityStateZip = new N4();
        relatedEntityContactInformation = new ArrayList<PER>();
        relatedProviderInformation = new PRV();
    }
    public BenefitResponseDependentBenefitRelatedEntity(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("NM1"))
            relatedEntityName = new NM1(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N3"))
            relatedEntityAddress = new N3(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("N4"))
            relatedEntityCityStateZip = new N4(stringQueue.getNext());
        while (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PER"))
            relatedEntityContactInformation.add(new PER(stringQueue.getNext()));
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("PRV"))
            relatedProviderInformation = new PRV(stringQueue.getNext());

        if (stringQueue.hasNext()) {
            logger.warn("Unexpected string in "+this.getClass().getName());
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();

        messagesDefinition.add(relatedEntityName);
        messagesDefinition.add(relatedEntityAddress);
        messagesDefinition.add(relatedEntityCityStateZip);
        messagesDefinition.addAll(relatedEntityContactInformation);
        messagesDefinition.add(relatedProviderInformation);
    }

    public NM1 getRelatedEntityName() {
        return relatedEntityName;
    }

    public void setRelatedEntityName(NM1 relatedEntityName) {
        this.relatedEntityName = relatedEntityName;
    }

    public N3 getRelatedEntityAddress() {
        return relatedEntityAddress;
    }

    public void setRelatedEntityAddress(N3 relatedEntityAddress) {
        this.relatedEntityAddress = relatedEntityAddress;
    }

    public N4 getRelatedEntityCityStateZip() {
        return relatedEntityCityStateZip;
    }

    public void setRelatedEntityCityStateZip(N4 relatedEntityCityStateZip) {
        this.relatedEntityCityStateZip = relatedEntityCityStateZip;
    }

    public List<PER> getRelatedEntityContactInformation() {
        return relatedEntityContactInformation;
    }

    public void setRelatedEntityContactInformation(List<PER> relatedEntityContactInformation) {
        this.relatedEntityContactInformation = relatedEntityContactInformation;
    }

    public PRV getRelatedProviderInformation() {
        return relatedProviderInformation;
    }

    public void setRelatedProviderInformation(PRV relatedProviderInformation) {
        this.relatedProviderInformation = relatedProviderInformation;
    }
}
