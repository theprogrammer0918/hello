package com.omcodes.hello.helloworld;

public class helloworldbean {
    private String message;

    public helloworldbean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "helloworldbean [message=" + message + "]";
    }

    // @Override
    // public String toString() {
    // return String.format("helloworldbean [message=%s]", message);
    // }

}
