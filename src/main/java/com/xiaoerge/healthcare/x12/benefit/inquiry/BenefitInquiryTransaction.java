package com.xiaoerge.healthcare.x12.benefit.inquiry;

import com.xiaoerge.healthcare.x12.util.SegmentStringUtil;
import com.xiaoerge.healthcare.x12.control.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class BenefitInquiryTransaction extends Transaction {

    private List<BenefitInquiryInformationSource> benefitInquiryInformationSources;
    public BenefitInquiryTransaction() {
        super();
        benefitInquiryInformationSources = new ArrayList<BenefitInquiryInformationSource>();
    }

    public BenefitInquiryTransaction(String s) {
        super(s);
        benefitInquiryInformationSources = new ArrayList<BenefitInquiryInformationSource>();
        parseContent();
    }

    public BenefitInquiryTransaction(Transaction transaction) {
        super(transaction);
        benefitInquiryInformationSources = new ArrayList<BenefitInquiryInformationSource>();
        parseContent();
    }

    private void parseContent() {
        String[] sourceStrings = SegmentStringUtil.split(getContent(), "HL");
        String[] informationSources = SegmentStringUtil.joinLevel(sourceStrings);

        //multiple sources
        for (String sourceString : informationSources) {
            benefitInquiryInformationSources.add(new BenefitInquiryInformationSource(sourceString));
        }
    }

    public void loadDefinition() {
        messagesDefinition.clear();
        messagesDefinition.add(getTransactionSetHeader());
        messagesDefinition.add(getBeginningOfHierarchicalTransaction());
        messagesDefinition.addAll(benefitInquiryInformationSources);
        messagesDefinition.add(getTransactionSetTrailer());
    }

    public List<BenefitInquiryInformationSource> getBenefitInquiryInformationSources() {
        return benefitInquiryInformationSources;
    }

    public void setBenefitInquiryInformationSources(List<BenefitInquiryInformationSource> benefitInquiryInformationSources) {
        this.benefitInquiryInformationSources = benefitInquiryInformationSources;
    }
}
