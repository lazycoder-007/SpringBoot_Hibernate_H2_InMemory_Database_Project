package com.hibernate.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotPresentException.class)
    public ResponseEntity<?> EmployeeNotFoundError() {
       return new ResponseEntity<>("OKAY", HttpStatus.OK);
    }
}
