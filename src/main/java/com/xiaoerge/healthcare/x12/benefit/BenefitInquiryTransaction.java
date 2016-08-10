package com.xiaoerge.healthcare.x12.benefit;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.control.Transaction;
import com.xiaoerge.healthcare.x12.segment.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class BenefitInquiryTransaction extends Transaction
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<BenefitInformationSource> benefitInformationSources;
    public BenefitInquiryTransaction() {
        super();
        benefitInformationSources = new ArrayList<BenefitInformationSource>();
    }

    public BenefitInquiryTransaction(String s) {
        super(s);
        benefitInformationSources = new ArrayList<BenefitInformationSource>();
        parseContent();
    }

    public BenefitInquiryTransaction(Transaction transaction) {
        super(transaction);
        benefitInformationSources = new ArrayList<BenefitInformationSource>();
        parseContent();
    }

    private void parseContent() {
        StringQueue stringQueue = new StringQueue(getContent());
        StringBuilder stringBuilder = new StringBuilder();

        while (stringQueue.hasNext()) {
            String peek = stringQueue.peekNext();
            String next = stringQueue.getNext();

            if (new HL(peek).getHierarchicalParentIDNumber().length() == 0
                    && stringBuilder.length() > 0) {
                stringBuilder.append(next);

                BenefitInformationSource source = new BenefitInformationSource(stringBuilder.toString());
                benefitInformationSources.add(source);
                stringBuilder = new StringBuilder();

                logger.info("size "+benefitInformationSources.size()+"");

                logger.info("Start hierarchical level "+ next);
            }
            else {
                stringBuilder.append(next);
                logger.info("Found segment "+ next);
            }
        }
    }

    public String toX12String() {
        StringBuilder stringBuilder = new StringBuilder(super.toX12String());
        for (BenefitInformationSource source : benefitInformationSources) {
            stringBuilder.append(source.toX12String());
        }
        return stringBuilder.toString();
    }
}
