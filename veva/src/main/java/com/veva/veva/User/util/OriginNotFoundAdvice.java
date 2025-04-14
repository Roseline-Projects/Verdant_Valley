package com.veva.veva.User.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OriginNotFoundAdvice { //return feedback to the controller about what went wrong
    @ExceptionHandler(OriginNotFoundException.class) //run this handler only for this exception type
    @ResponseStatus(HttpStatus.BAD_REQUEST) //bad format
    String originNotFoundHandler(OriginNotFoundException exp) {
        return exp.getMessage(); //exception messages
    }
    
}
