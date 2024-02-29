package com.project.libraraymgm.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class, ResourceAlreadyExistsException.class, Exception.class})
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse err;

        if (ex instanceof StudentNotFoundException) {
           err  = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());

        } else if (ex instanceof ResourceAlreadyExistsException) {
            err = new ErrorResponse(HttpStatus.CONFLICT, ex.getMessage());

        } else if (ex instanceof InvalidRequestBodyException) {
            err = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        else {
            err = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
        return new ResponseEntity(err, err.status);
    }
}
