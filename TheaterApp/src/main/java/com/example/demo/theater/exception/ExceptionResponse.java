package com.example.demo.theater.exception;

import lombok.Data;
import java.util.Date;

@Data
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date date, String message, String description) {
    }
}
