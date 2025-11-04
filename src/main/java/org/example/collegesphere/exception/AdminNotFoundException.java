package org.example.collegesphere.exception;

public class AdminNotFoundException extends Exception {
    public AdminNotFoundException() {
        super("admin not found");
    }
    public AdminNotFoundException(String msg){
        super(msg);
    }
    public AdminNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
}
