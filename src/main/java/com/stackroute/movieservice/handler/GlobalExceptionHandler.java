package com.stackroute.movieservice.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleMoviealreadyExistException(Exception e){
        return new ResponseEntity<String>("Global Exception thrown here"+ e.getMessage(), HttpStatus.CONFLICT);
    }
}
