package com.task.mysolve.exception;

public class FormValidationException extends RuntimeException {
    public FormValidationException() {
    }

    public FormValidationException(String message) {
        super(message);
    }
}
