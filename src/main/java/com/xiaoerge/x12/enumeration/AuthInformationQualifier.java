package com.xiaoerge.x12.enumeration;

/**
 * Created by xiaoerge on 5/26/16.
 */
public enum  AuthInformationQualifier {
    Unset(""),
    NoAuthorizationInformation("00"),
    AdditionalDataIdentification("03");

    private String codeValue;
    AuthInformationQualifier(String s)
    {
        codeValue = s;
    }

    public String toString() {
        return codeValue;
    }
}
