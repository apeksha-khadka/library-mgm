package com.project.libraraymgm.manager.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(int id) {
        super("Student  with Id: " + id + " not found.");
    }
}
