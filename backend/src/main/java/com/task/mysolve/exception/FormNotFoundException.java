package com.task.mysolve.exception;

public class FormNotFoundException extends RuntimeException {
    public FormNotFoundException() {
    }

    public FormNotFoundException(String message) {
        super(message);
    }
}
