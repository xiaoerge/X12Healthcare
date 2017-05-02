package com.xiaoerge.x12.message.control;

import com.xiaoerge.x12.message.MessageLoop;
import com.xiaoerge.x12.message.segment.GE;
import com.xiaoerge.x12.message.segment.GS;
import com.xiaoerge.x12.util.StringQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class FunctionalGroup extends MessageLoop {
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

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(functionalGroupHeader);
        messagesDefinition.addAll(transactions);
        messagesDefinition.add(functionalGroupTrailer);
    }

    public GS getFunctionalGroupHeader() {
        return functionalGroupHeader;
    }

    public void setFunctionalGroupHeader(GS functionalGroupHeader) {
        this.functionalGroupHeader = functionalGroupHeader;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public GE getFunctionalGroupTrailer() {
        return functionalGroupTrailer;
    }

    public void setFunctionalGroupTrailer(GE functionalGroupTrailer) {
        this.functionalGroupTrailer = functionalGroupTrailer;
    }
}
