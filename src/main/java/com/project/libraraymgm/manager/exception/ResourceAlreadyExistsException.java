package com.project.libraraymgm.manager.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String entityName) {
        super(entityName + " with this information already exists");
    }
}
