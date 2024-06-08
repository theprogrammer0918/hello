package com.omcodes.hello.exceptions;

import java.util.Date;

public class exceptionResponse {
    private Date timestam;
    private String message;
    private String details;
    public exceptionResponse(Date timestam, String message, String details) {
        this.timestam = timestam;
        this.message = message;
        this.details = details;
    }
    public Date getTimestam() {
        return timestam;
    }
    public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }
}
