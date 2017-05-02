package com.xiaoerge.x12.message.control;

import com.xiaoerge.x12.message.MessageFormat;
import com.xiaoerge.x12.message.segment.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 5/23/16.
 */
public class ControlTest {

    @Test
    public void testCreateFunctionalGroup() {
        FunctionalGroup functionalGroup = new FunctionalGroup();
        GS gs = new GS();
        GE ge = new GE();
        List<Transaction> transactions = new ArrayList<Transaction>();
        Transaction transaction = new Transaction();

        ge.setNumberOfTransactionsSetsIncluded("1");
        ge.setGroupControlNumber("0616");

        gs.setFunctionalIDCode("HC");
        gs.setApplicationSendersCode("SUBMITTERS Code");
        gs.setApplicationReceiversCode("RECEIVERS Code");
        gs.setDate("20160524");
        gs.setTime("0616");
        gs.setGroupControlNumber("126");
        gs.setResponsibleAgencyCode("X");
        gs.setVersionReleaseIndustryIDCode("005010X222A1");

        transactions.add(transaction);

        functionalGroup.setFunctionalGroupHeader(gs);
        functionalGroup.setFunctionalGroupTrailer(ge);
        functionalGroup.setTransactions(transactions);

        Assert.assertEquals("GS*HC*SUBMITTERS Code*RECEIVERS Code*20160524*0616*126*X*005010X222A1~", functionalGroup.getFunctionalGroupHeader().toString());
        Assert.assertEquals("GE*1*0616~", functionalGroup.getFunctionalGroupTrailer().toString());
        Assert.assertEquals(1, functionalGroup.getTransactions().size());
        Assert.assertEquals("", functionalGroup.getTransactions().get(0).toString());
    }

    @Test
    public void testParseTransaction() {
        //need to escape *
        String x12 = "ST***~BHT\\*\\*\\*\\*\\*\\*~SE**~";
        Transaction transaction = new Transaction(x12, new MessageFormat());

        Assert.assertFalse(transaction.validate());
        Assert.assertFalse(transaction.isEmpty());
        Assert.assertNotEquals(x12, transaction.toX12String());
    }

    @Test
    public void testCreateTransaction() {
        String x12 = "ST***~BHT******~SE**~";
        Transaction transaction = new Transaction();

        transaction.setTransactionSetHeader(new ST());
        transaction.setTransactionSetTrailer(new SE());
        transaction.setBeginningOfHierarchicalTransaction(new BHT());

        Assert.assertTrue(transaction.validate());
        Assert.assertTrue(transaction.isEmpty());
        Assert.assertEquals("", transaction.toX12String());
    }
}
