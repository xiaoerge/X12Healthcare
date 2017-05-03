package com.xiaoerge.x12.util;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.MessageFormatException;
import com.xiaoerge.x12.message.X12Message;
import com.xiaoerge.x12.message.benefit.inquiry.BenefitInquiry;
import com.xiaoerge.x12.message.benefit.response.BenefitResponse;
import com.xiaoerge.x12.message.claim.payment.ClaimPayment;
import com.xiaoerge.x12.message.control.FunctionalGroup;
import com.xiaoerge.x12.message.control.InterchangeEnvelope;
import com.xiaoerge.x12.message.control.Transaction;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by xiaoerge on 5/28/16.
 */
public class X12Parser {
	
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(X12Parser.class);

    public static X12Message fromX12Message(String s) throws MessageFormatException {

    	MessageFormat mf = parseMessageFormat(s);
    	if (mf==null) return null;
        X12Message message = new X12Message(s, mf);
        InterchangeEnvelope envelope = message.getInterchangeEnvelope();
        List<FunctionalGroup> groups = envelope.getFunctionalGroups();

        Transaction transaction = groups.get(0).getTransactions().get(0);

        if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("270")) {
            X12Message m = new BenefitInquiry(message);
            return new BenefitInquiry(message);
        }
        else if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("271")) {
            return new BenefitResponse(message);
        }
        else if (transaction.getTransactionSetHeader().getTransactionSetIDCode().equals("835")) {
            return new ClaimPayment(message);
        }

        return message;
    }
    public static MessageFormat parseMessageFormat(String x12) 
    {
    	MessageFormat mf = new MessageFormat();
    	if (x12==null || x12.length()<106) {
            logger.warn("parseMessageFormat() ISA segment too short");
    		return mf;
    	}
    	if (!"ISA".equals(x12.substring(0,3))) {
            logger.warn("parseMessageFormat() first segment is not ISA");
    		return mf;
    	};
    	String s = x12.substring(0, 108);
    	mf.setDataElementSeparator(s.substring(3,4));
    	mf.setSegmentTerminator(s.substring(105,106));
    	String[] fields = s.split(Pattern.quote(mf.getDataElementSeparator()));
    	mf.setRepetitionSeparator(fields[11].substring(0,1));
    	mf.setComponentElementSeparator(fields[16].substring(0,1));
    	if (s.charAt(106) == '\r' && s.charAt(107)=='\n') {
    		mf.setSuffix("\r\n");
    	} else if (s.charAt(106) == '\r') {
    		mf.setSuffix("\r");
    	} else if (s.charAt(106) == '\n') {
    		mf.setSuffix("\n");
    	}
    	
    	return mf;
    }

}
