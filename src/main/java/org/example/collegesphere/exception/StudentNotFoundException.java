package org.example.collegesphere.exception;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String msg) {
        super(msg);
    }
    public StudentNotFoundException(){
        super("students not found");
    }
    public StudentNotFoundException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}
