package com.xiaoerge.x12.control;

import com.xiaoerge.x12.segment.GE;
import com.xiaoerge.x12.segment.GS;
import com.xiaoerge.x12.util.StringQueue;
import com.xiaoerge.x12.message.MessageBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class FunctionalGroup extends MessageBase {
    private GS functionalGroupHeader;
    private List<Transaction> transactions;
    private GE functionalGroupTrailer;

    public FunctionalGroup() {
        functionalGroupHeader = new GS();
        transactions = new ArrayList<Transaction>();
        functionalGroupTrailer = new GE();
    }
    public FunctionalGroup(String s) {
        StringQueue stringQueue = new StringQueue(s);
        transactions = new ArrayList<Transaction>();

        StringBuilder builder = null;
        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("GS")) {
                functionalGroupHeader = new GS(next);
            }
            else if (next.startsWith("GE")) {
                functionalGroupTrailer = new GE(next);
            }
            else if (next.startsWith("ST")) {
                builder = new StringBuilder();
                builder.append(next);
            }
            else if (next.startsWith("SE")) {
                if (builder != null) {
                    builder.append(next);
                    String groupContent = builder.toString();
                    Transaction transaction = new Transaction(groupContent);
                    transactions.add(transaction);
                }
            }
            else {
                if (builder != null) builder.append(next);
            }
        }
    }

    public GS getFunctionalGroupHeader() {return functionalGroupHeader;}
    public GE getFunctionalGroupTrailer() {return functionalGroupTrailer;}
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(functionalGroupHeader);
        messagesDefinition.addAll(transactions);
        messagesDefinition.add(functionalGroupTrailer);
    }
}
