package com.project.libraraymgm.manager.exception;

public class InvalidRequestBodyException extends RuntimeException {
    public InvalidRequestBodyException() {
        super("invalid request body");
    }
}