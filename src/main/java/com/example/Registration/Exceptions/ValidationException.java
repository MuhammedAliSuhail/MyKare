package com.example.Registration.Exceptions;

public class ValidationException extends SystemException{
    public ValidationException(String statusCode, String responseMessage, String responseIndicator) {
        super(statusCode, responseMessage, responseIndicator);
    }
}
