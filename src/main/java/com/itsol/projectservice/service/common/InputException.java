package com.itsol.projectservice.service.common;

public class InputException extends Exception {

    public InputException(String message){
        super(message);
    }
    @Override
    public String getMessage(){
        return "Error: " +super.getMessage();
    }
}
