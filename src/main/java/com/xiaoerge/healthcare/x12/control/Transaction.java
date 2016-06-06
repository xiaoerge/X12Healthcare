package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.BHT;
import com.xiaoerge.healthcare.x12.segment.SE;
import com.xiaoerge.healthcare.x12.segment.ST;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class Transaction implements IMessage
{
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
                builder.append(next).append("~");
            }
        }
        content = builder.toString();
    }
    public String getContent() {
        return content;
    }

    public String getTransactionSetIDCode() {
        return transactionSetHeader.getTransactionSetIDCode();
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
}
