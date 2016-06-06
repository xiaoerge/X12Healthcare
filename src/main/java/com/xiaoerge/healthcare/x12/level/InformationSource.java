package com.xiaoerge.healthcare.x12.level;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.HL;
import com.xiaoerge.healthcare.x12.segment.NM1;

/**
 * Created by xiaoerge on 6/5/16.
 */
public class InformationSource implements IMessage {

    private HL hierarchicalLevel;
    private NM1 individualOrOrganizationalName;

    public InformationSource() {
        hierarchicalLevel = new HL();
        individualOrOrganizationalName = new NM1();
    }

    public InformationSource(String s) {
        StringQueue stringQueue = new StringQueue(s);

        hierarchicalLevel = new HL(stringQueue.getNext());
        individualOrOrganizationalName = new NM1(stringQueue.getNext());
    }

    public boolean validate() {
        return hierarchicalLevel.validate() && individualOrOrganizationalName.validate();
    }

    public String toX12String() {
        return hierarchicalLevel.toX12String()+"~"+individualOrOrganizationalName.toX12String()+"~";
    }
}
