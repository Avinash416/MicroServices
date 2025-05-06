package com.security.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (){
        super("Resource Not Found On The Server!!!");
    }

    public ResourceNotFoundException( String message){
        super(message);
    }
}
