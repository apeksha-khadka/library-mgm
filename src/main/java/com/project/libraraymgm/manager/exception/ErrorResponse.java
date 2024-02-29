package com.project.libraraymgm.manager.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    public HttpStatus status;
    public String message;

    public ErrorResponse(
            HttpStatus status,
            String message
    ) {
        this.status = status;
        this.message = message;
    }
}
