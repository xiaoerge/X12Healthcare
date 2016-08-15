package com.xiaoerge.ediparser.x12.control;

import com.xiaoerge.ediparser.x12.segment.BHT;
import com.xiaoerge.ediparser.x12.segment.SE;
import com.xiaoerge.ediparser.x12.segment.ST;
import com.xiaoerge.ediparser.x12.util.StringQueue;
import com.xiaoerge.ediparser.x12.message.MessageBase;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class Transaction extends MessageBase {
    private ST transactionSetHeader;
    private BHT beginningOfHierarchicalTransaction;
    private SE transactionSetTrailer;
    private String content;

    public Transaction() {
        transactionSetHeader = new ST();
        beginningOfHierarchicalTransaction = new BHT();
        transactionSetTrailer = new SE();

        content = "";
    }

    public Transaction(String s) {
        this();
        StringQueue stringQueue = new StringQueue(s);
        StringBuilder builder = new StringBuilder();

        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("ST")) {
                transactionSetHeader = new ST(next);
            }
            else if (next.startsWith("BHT")) {
                beginningOfHierarchicalTransaction = new BHT(next);
            }
            else if (next.startsWith("SE")) {
                transactionSetTrailer = new SE(next);
            }
            else {
                builder.append(next);
            }
        }
        content = builder.toString();
    }
    public Transaction(Transaction transaction) {
        transactionSetHeader = transaction.getTransactionSetHeader();
        beginningOfHierarchicalTransaction = transaction.getBeginningOfHierarchicalTransaction();
        transactionSetTrailer = transaction.getTransactionSetTrailer();
        content = transaction.getContent();
    }
    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(transactionSetHeader);
        messagesDefinition.add(beginningOfHierarchicalTransaction);
        messagesDefinition.add(transactionSetTrailer);
    }

    public String getContent() {
        return content;
    }

    public ST getTransactionSetHeader() {
        return transactionSetHeader;
    }

    public void setTransactionSetHeader(ST transactionSetHeader) {
        this.transactionSetHeader = transactionSetHeader;
    }

    public BHT getBeginningOfHierarchicalTransaction() {
        return beginningOfHierarchicalTransaction;
    }

    public void setBeginningOfHierarchicalTransaction(BHT beginningOfHierarchicalTransaction) {
        this.beginningOfHierarchicalTransaction = beginningOfHierarchicalTransaction;
    }

    public SE getTransactionSetTrailer() {
        return transactionSetTrailer;
    }

    public void setTransactionSetTrailer(SE transactionSetTrailer) {
        this.transactionSetTrailer = transactionSetTrailer;
    }
}
