package com.xiaoerge.x12.message.claim.payment;

import com.xiaoerge.x12.message.control.Transaction;
import com.xiaoerge.x12.message.segment.*;
import com.xiaoerge.x12.util.SegmentStringUtil;
import com.xiaoerge.x12.util.StringQueue;

/**
 * Created by xiaoerge on 9/3/16.
 */
public class ClaimPaymentTransaction extends Transaction {

    private BPR financialInformation;
    private TRN reassociationTraceNumber;
    private CUR foreignCurrencyInformation;
    private REF receiverIdentification;
    private REF versionIdentification;
    private DTM productionDate;

    public ClaimPaymentTransaction() {
        super();
        financialInformation = new BPR();
        reassociationTraceNumber = new TRN();
        foreignCurrencyInformation = new CUR();
        receiverIdentification = new REF();
        versionIdentification = new REF();
        productionDate = new DTM();
    }

    public ClaimPaymentTransaction(String s) {
        super(s);
        parseContent();
    }

    public ClaimPaymentTransaction(Transaction transaction) {
        super(transaction);
        parseContent();
    }

    private void parseContent() {
        StringBuilder builder = new StringBuilder();
        StringQueue stringQueue = new StringQueue(getContent());

        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("BPR"))
            financialInformation = new BPR(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("TRN"))
            reassociationTraceNumber = new TRN(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("CUR"))
            foreignCurrencyInformation = new CUR(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))
            receiverIdentification = new REF(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("REF"))//todo check order
            versionIdentification = new REF(stringQueue.getNext());
        if (stringQueue.hasNext() && stringQueue.peekNext().startsWith("DTM"))
            productionDate = new DTM(stringQueue.getNext());

        while (stringQueue.hasNext()) {
            builder.append(stringQueue.getNext());
        }

        System.out.println(builder.toString());

        String[] s2 = SegmentStringUtil.split(builder.toString(), "N1");
        for(String s : s2) {
            System.out.println(s);
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(getTransactionSetHeader());
        messagesDefinition.add(getTransactionSetTrailer());
    }


}
