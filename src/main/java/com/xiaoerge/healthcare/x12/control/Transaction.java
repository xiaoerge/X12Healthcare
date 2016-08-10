package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.IMessage;
import com.xiaoerge.healthcare.x12.segment.BHT;
import com.xiaoerge.healthcare.x12.segment.SE;
import com.xiaoerge.healthcare.x12.segment.ST;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class Transaction implements IMessage
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
                logger.info("Start transaction ", next);
            }
            else if (next.startsWith("BHT")) {
                beginningOfHierarchicalTransaction = new BHT(next);
                logger.info("Start hierarchical transaction ", next);
            }
            else if (next.startsWith("SE")) {
                transactionSetTrailer = new SE(next);
                logger.info("End transaction ", next);
            }
            else {
                builder.append(next);
                logger.info("Found segment", next);
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
    public String getContent() {
        return content;
    }

    public boolean validate() {
        boolean b1 = transactionSetHeader.validate();
        boolean b2 = beginningOfHierarchicalTransaction.validate();
        boolean b3 = transactionSetTrailer.validate();
        return b1 && b2 && b3;
    }

    public String toX12String() {
        return transactionSetHeader.toString() +
                beginningOfHierarchicalTransaction.toString() +
                transactionSetTrailer.toString();
    }

    public String toString() { return toX12String(); }

    public boolean isEmpty() {
        boolean b1 = transactionSetHeader.isEmpty();
        boolean b2 = beginningOfHierarchicalTransaction.isEmpty();
        boolean b3 = transactionSetTrailer.isEmpty();
        return b1 && b2 && b3;
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
