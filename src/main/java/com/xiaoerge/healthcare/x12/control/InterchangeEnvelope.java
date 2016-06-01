package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.GS;
import com.xiaoerge.healthcare.x12.segment.IEA;
import com.xiaoerge.healthcare.x12.segment.ISA;
import com.xiaoerge.healthcare.x12.segment.Segment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class InterchangeEnvelope implements IMessage
{
    private ISA isa;
    private List<FunctionalGroup> functionalGroups;
    private IEA iea;

    public InterchangeEnvelope() {
        isa = new ISA();
        functionalGroups = new ArrayList<FunctionalGroup>();
        iea = new IEA();
    }
    public InterchangeEnvelope(String s) {
        StringQueue stringQueue = new StringQueue(s);
        functionalGroups = new ArrayList<FunctionalGroup>();

        StringBuilder builder = null;
        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("ISA")) {
                isa = new ISA(next);
            }
            else if (next.startsWith("IEA")) {
                iea = new IEA(next);
            }
            else if (next.startsWith("GS")) {
                builder = new StringBuilder();
                builder.append(next);
            }
            else if (next.startsWith("GE")) {
                if (builder != null) {
                    builder.append(next);
                    String groupContent = builder.toString();
                    FunctionalGroup group = new FunctionalGroup(groupContent);
                    functionalGroups.add(group);
                }
            }
            else {
                if (builder != null) builder.append(next);
            }
        }
    }

    public List<FunctionalGroup> getFunctionalGroups() {
        return functionalGroups;
    }

    public boolean validate() {
        for (FunctionalGroup group : functionalGroups) {
            if (!group.validate()) return false;
        }
        return isa.validate() && iea.validate();
    }

    public int size() {
        return 2 + functionalGroups.size();
    }

    public String toX12String() {
        StringBuilder builder = new StringBuilder();
        builder.append(isa.toX12String());

        for (FunctionalGroup group : functionalGroups) {
            builder.append(group.toX12String());
        }

        builder.append(iea.toX12String());
        return builder.toString();
    }
}
