package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.segment.GE;
import com.xiaoerge.healthcare.x12.segment.GS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class FunctionalGroup implements IMessage
{
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

    public boolean validate() {
        for (Transaction transaction : transactions) {
            if (!transaction.validate()) return false;
        }
        return functionalGroupHeader.validate() && functionalGroupTrailer.validate();
    }

    public int size() {
        return 2 + transactions.size();
    }

    public String toX12String() {
        return toString();
    }

    public boolean isEmpty() {
        for (Transaction transaction : transactions) {
            if (!transaction.isEmpty()) return false;
        }
        return functionalGroupHeader.isEmpty() && functionalGroupTrailer.isEmpty();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(functionalGroupHeader.toX12String());

        for (Transaction transaction : transactions) {
            builder.append(transaction.toX12String());
        }

        builder.append(functionalGroupTrailer.toX12String());
        return builder.toString();
    }
}
