package com.ars.task.exeptions;
/*
Exception for business logic errors, mainly for lack of mandatory fields in JSON requests
 */
public class BusinessErrorException extends RuntimeException{
    public BusinessErrorException(String message) {
        super(message);
    }
}
