package com.xiaoerge.x12.message.claim.payment;

import com.xiaoerge.x12.message.MessageLoop;
import com.xiaoerge.x12.message.segment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoerge on 9/3/16.
 */
public class ClaimPayerIdentification extends MessageLoop {

    private N1 payerIdentification;
    private N3 payerAddress;
    private N4 payerCityState;
    private REF additionalPayerInformation;
    private List<PER> payerContactInformation;

    public ClaimPayerIdentification() {
        payerIdentification = new N1();
        payerAddress = new N3();
        payerCityState = new N4();
        additionalPayerInformation = new REF();
        payerContactInformation = new ArrayList<PER>();
    }
    public ClaimPayerIdentification(String s) {
        this();

        //todo parsing
    }

    public void loadDefinition() {

    }
}
