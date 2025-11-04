package org.example.collegesphere.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GenericException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException userNotFoundException){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),userNotFoundException.getMessage(),"User " +
                "not found");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> handleStudentNotFound(StudentNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),e.getMessage(),"students not found");
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),e.getMessage(),"somthing is wrong");
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),e.getMessage(),"Something is wrong");
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<?> handleAdminNotFoundException(AdminNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),e.getMessage(),"admin not found");
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<?> handleTeacherNotFoundException(TeacherNotFoundException e){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),e.getMessage(),"Teacher not found");
        return  new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

}
