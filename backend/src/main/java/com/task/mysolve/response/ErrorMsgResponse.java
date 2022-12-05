package com.task.mysolve.response;

public class ErrorMsgResponse {
    private String message;

    public ErrorMsgResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
