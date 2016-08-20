package com.xiaoerge.x12.control;

import com.xiaoerge.x12.util.StringQueue;
import com.xiaoerge.x12.message.MessageBase;
import com.xiaoerge.x12.segment.IEA;
import com.xiaoerge.x12.segment.ISA;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaoerge on 5/23/16.
 */
public class InterchangeEnvelope extends MessageBase {
    private ISA transactionSetHeader;
    private List<FunctionalGroup> functionalGroups;
    private IEA transactionSetTrailer;

    public InterchangeEnvelope() {
        transactionSetHeader = new ISA();
        functionalGroups = new ArrayList<FunctionalGroup>();
        transactionSetTrailer = new IEA();
    }
    public InterchangeEnvelope(String s) {
        StringQueue stringQueue = new StringQueue(s);
        functionalGroups = new ArrayList<FunctionalGroup>();

        StringBuilder builder = null;
        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("ISA")) {
                transactionSetHeader = new ISA(next);
            }
            else if (next.startsWith("IEA")) {
                transactionSetTrailer = new IEA(next);
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

    public ISA getTransactionSetHeader() { return transactionSetHeader; }
    public IEA getTransactionSetTrailer() { return transactionSetTrailer; }
    public List<FunctionalGroup> getFunctionalGroups() {
        return functionalGroups;
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(transactionSetHeader);
        messagesDefinition.addAll(getFunctionalGroups());
        messagesDefinition.add(transactionSetTrailer);
    }
}
