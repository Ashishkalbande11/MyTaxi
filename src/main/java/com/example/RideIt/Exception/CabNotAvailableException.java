package com.example.RideIt.Exception;


public class CabNotAvailableException extends RuntimeException {
    public CabNotAvailableException(String message){
        super(message);
    }
}
