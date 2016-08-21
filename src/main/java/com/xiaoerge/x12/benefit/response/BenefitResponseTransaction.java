package com.xiaoerge.x12.benefit.response;

import com.xiaoerge.x12.control.Transaction;
import com.xiaoerge.x12.util.SegmentStringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class BenefitResponseTransaction extends Transaction {

    private List<BenefitResponseInformationSource> informationSources;
    public BenefitResponseTransaction() {
        super();
        informationSources = new ArrayList<BenefitResponseInformationSource>();
    }

    public BenefitResponseTransaction(String s) {
        super(s);
        informationSources = new ArrayList<BenefitResponseInformationSource>();
        parseContent();
    }

    public BenefitResponseTransaction(Transaction transaction) {
        super(transaction);
        informationSources = new ArrayList<BenefitResponseInformationSource>();
        parseContent();
    }

    private void parseContent() {
        String[] sourceStrings = SegmentStringUtil.split(getContent(), "HL");
        String[] informationSources = SegmentStringUtil.joinLevel(sourceStrings);
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(getTransactionSetHeader());
        messagesDefinition.add(getBeginningOfHierarchicalTransaction());
        messagesDefinition.addAll(informationSources);
        messagesDefinition.add(getTransactionSetTrailer());
    }
}
