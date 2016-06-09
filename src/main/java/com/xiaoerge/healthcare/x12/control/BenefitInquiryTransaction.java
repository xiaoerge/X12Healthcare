package com.xiaoerge.healthcare.x12.control;

import com.xiaoerge.healthcare.x12.StringQueue;
import com.xiaoerge.healthcare.x12.loop.BenefitInformationReceiver;
import com.xiaoerge.healthcare.x12.loop.BenefitInformationSource;
import com.xiaoerge.healthcare.x12.message.BenefitInquiry;
import com.xiaoerge.healthcare.x12.message.IMessage;
import com.xiaoerge.healthcare.x12.segment.BHT;
import com.xiaoerge.healthcare.x12.segment.HL;
import com.xiaoerge.healthcare.x12.segment.SE;
import com.xiaoerge.healthcare.x12.segment.ST;

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

        while (stringQueue.hasNext()) {
            String next = stringQueue.getNext();
            if (next.startsWith("HL")) {
                HL level = new HL(next);
                if (level.getHierarchicalChildCode().equals("1")) {
                    System.out.println(level.toX12String());
                }

            }
        }
    }
}
