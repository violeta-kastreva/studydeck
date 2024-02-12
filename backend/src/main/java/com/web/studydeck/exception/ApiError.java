package com.web.studydeck.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;


    public HttpStatus getStatus() {
        return status;
    }

    public ApiError(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }


    // Constructor, getters, and setters
}