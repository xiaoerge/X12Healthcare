package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.loop.BenefitInformationReceiver;
import com.xiaoerge.healthcare.x12.loop.BenefitInformationSource;
import com.xiaoerge.healthcare.x12.message.BenefitInquiry;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/27/16.
 */
public class BenefitInquiryTransaction extends Transaction
{
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

    public void parseContent() {
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
            }
            else stringBuilder.append(next);
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
