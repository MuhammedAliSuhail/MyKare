package com.example.Registration.Exceptions;

public class IoExceptionCustom extends SystemException{
    public IoExceptionCustom(String statusCode, String responseMessage, String responseIndicator) {
        super(statusCode, responseMessage, responseIndicator);
    }
}
