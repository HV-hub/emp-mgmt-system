package com.employeemgmt.empMgmtSystem.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
