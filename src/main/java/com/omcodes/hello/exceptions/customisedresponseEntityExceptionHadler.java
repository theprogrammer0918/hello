package com.omcodes.hello.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.omcodes.hello.user.UserNotFoundException;

@ControllerAdvice
@RestController
class customisedresponseEntityExceptionHadler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        exceptionResponse res = new exceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
        exceptionResponse res = new exceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(res, HttpStatus.NOT_FOUND);
    }
}