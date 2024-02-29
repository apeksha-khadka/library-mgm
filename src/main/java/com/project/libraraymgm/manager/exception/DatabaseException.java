package com.project.libraraymgm.manager.exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super("Unexpected database error: " + message);
    }
}
