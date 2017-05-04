package com.xiaoerge.x12.message.benefit.response;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.control.Transaction;
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

    public BenefitResponseTransaction(String s, MessageFormat mf) {
        super(s, mf);
        informationSources = new ArrayList<BenefitResponseInformationSource>();
        parseContent();
    }

    public BenefitResponseTransaction(Transaction transaction) {
        super(transaction);
        informationSources = new ArrayList<BenefitResponseInformationSource>();
        parseContent();
    }

    private void parseContent() {
        String[] sourceStrings = SegmentStringUtil.split(getContent(), "HL", messageFormat);
        String[] sources = SegmentStringUtil.joinLevel(sourceStrings, messageFormat);

        for (String str : sources) {
            informationSources.add(new BenefitResponseInformationSource(str, messageFormat));
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(getTransactionSetHeader());
        messagesDefinition.add(getBeginningOfHierarchicalTransaction());
        messagesDefinition.addAll(informationSources);
        messagesDefinition.add(getTransactionSetTrailer());
    }

    public List<BenefitResponseInformationSource> getInformationSources() {
        return informationSources;
    }

    public void setInformationSources(List<BenefitResponseInformationSource> informationSources) {
        this.informationSources = informationSources;
    }
}
