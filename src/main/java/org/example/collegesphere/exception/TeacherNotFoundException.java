package org.example.collegesphere.exception;

public class TeacherNotFoundException extends  Exception{
    public TeacherNotFoundException(){
        super("Teacher Not found");
    }
    public TeacherNotFoundException(String msg,Throwable cause){
        super(msg,cause);
    }
    public TeacherNotFoundException(String msg){
        super(msg);
    }

}
