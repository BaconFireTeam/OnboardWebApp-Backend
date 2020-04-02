package com.baconfire.onboardwebapp.aop.domain;

public class Info {

    public Info() {

    }

    public Info(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

}
