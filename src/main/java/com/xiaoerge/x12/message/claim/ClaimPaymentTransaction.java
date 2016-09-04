package com.xiaoerge.x12.message.claim;

import com.xiaoerge.x12.message.control.Transaction;

/**
 * Created by xiaoerge on 9/3/16.
 */
public class ClaimPaymentTransaction extends Transaction {

    public ClaimPaymentTransaction() {
        super();
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
        System.out.println(getContent());
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(getTransactionSetHeader());
        messagesDefinition.add(getTransactionSetTrailer());
    }
}
