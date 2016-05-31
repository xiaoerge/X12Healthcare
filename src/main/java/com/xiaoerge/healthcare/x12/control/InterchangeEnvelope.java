package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.IEA;
import com.xiaoerge.healthcare.x12.segment.ISA;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class InterchangeEnvelope implements IMessage
{
    private ISA isa;
    private FunctionalGroup functionalGroup;
    private IEA iea;

    public InterchangeEnvelope() {
        isa = new ISA();
        functionalGroup = new FunctionalGroup();
        iea = new IEA();
    }
    public InterchangeEnvelope(String s) {

        StringQueue stringQueue = new StringQueue(s);
        String header = stringQueue.getHeader(), content = stringQueue.getContent(), trailer = stringQueue.getTrailer();

        isa = new ISA(header);
        functionalGroup = new FunctionalGroup(content);
        iea = new IEA(trailer);
    }

    public FunctionalGroup getFunctionalGroup() {
        return functionalGroup;
    }

    public boolean validate() {
        return isa.validate() && functionalGroup.validate() && iea.validate();
    }

    public int size() {
        return 2 + functionalGroup.size();
    }

    public String toX12String() {
        return isa.toX12String() + functionalGroup.toX12String() + iea.toX12String();
    }
}
