package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.segment.IEA;
import com.xiaoerge.healthcare.x12.segment.ISA;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaoerge on 5/23/16.
 */
public class InterchangeEnvelope extends IMessage {
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
                logger.info("Start interchange envelope ", next);
            }
            else if (next.startsWith("IEA")) {
                transactionSetTrailer = new IEA(next);
                logger.info("End interchange envelope ", next);
            }
            else if (next.startsWith("GS")) {
                builder = new StringBuilder();
                builder.append(next);
                logger.info("Start functional group ", next);
            }
            else if (next.startsWith("GE")) {
                if (builder != null) {
                    builder.append(next);
                    String groupContent = builder.toString();
                    FunctionalGroup group = new FunctionalGroup(groupContent);
                    functionalGroups.add(group);
                    logger.info("End functional group ", next);
                }
            }
            else {
                if (builder != null) builder.append(next);
                logger.info("Found segment ", next);
            }
        }
    }

    public ISA getTransactionSetHeader() { return transactionSetHeader; }
    public IEA getTransactionSetTrailer() { return transactionSetTrailer; }
    public List<FunctionalGroup> getFunctionalGroups() {
        return functionalGroups;
    }

    public boolean validate() {
        for (FunctionalGroup group : functionalGroups) {
            if (!group.validate()) return false;
        }
        return transactionSetHeader.validate() && transactionSetTrailer.validate();
    }

    public int size() {
        return 2 + functionalGroups.size();
    }

    public String toX12String() {
        StringBuilder builder = new StringBuilder();
        builder.append(transactionSetHeader.toX12String());

        for (FunctionalGroup group : functionalGroups) {
            builder.append(group.toX12String());
        }

        builder.append(transactionSetTrailer.toX12String());
        return builder.toString();
    }

    public boolean isEmpty() {
        return transactionSetHeader.isEmpty() && transactionSetTrailer.isEmpty();
    }
}
