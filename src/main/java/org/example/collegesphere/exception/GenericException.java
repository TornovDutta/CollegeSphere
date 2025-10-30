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

}
