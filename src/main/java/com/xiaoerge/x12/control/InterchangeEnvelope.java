package com.xiaoerge.x12.control;

import com.xiaoerge.x12.message.IMessage;
import com.xiaoerge.x12.segment.IEA;
import com.xiaoerge.x12.segment.ISA;

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

        String header = s, content = s, footer = s;

        isa = new ISA(header);
        functionalGroup = new FunctionalGroup(content);
        iea = new IEA(footer);
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
