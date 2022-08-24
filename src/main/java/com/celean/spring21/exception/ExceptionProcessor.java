package com.celean.spring21.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionProcessor {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<AppException> handle(EntityNotFoundException e, WebRequest request) {
        return new ResponseEntity<>(new AppException(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
