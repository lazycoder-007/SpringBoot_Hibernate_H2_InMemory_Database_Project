package com.hibernate.project.exceptions;

public class EmployeeNotPresentException extends RuntimeException {

    String message;

    public EmployeeNotPresentException(String message) {
        super(message);
        this.message = message;
    }
}
