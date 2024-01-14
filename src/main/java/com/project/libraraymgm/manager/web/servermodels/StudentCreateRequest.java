package com.project.libraraymgm.manager.web.servermodels;

import com.project.libraraymgm.manager.exception.InvalidRequestBodyException;
import lombok.Data;

import java.util.Arrays;

@Data
public class StudentCreateRequest {
    String firstName;
    String lastName;
    int matriculationNumber;
    Faculty faculty;
    String emailAddress;

    enum Faculty {
        EI,
        EM,
        PE,
    }

    public void validateRequestBody() {
        if (this.getMatriculationNumber() > 99999) {
            throw new InvalidRequestBodyException();
        }
        if (this.getFirstName().length() > 15) {
            throw new InvalidRequestBodyException();
        }
        if (this.getLastName().length() > 15) {
            throw new InvalidRequestBodyException();
        }
        if((this.faculty != null) && Arrays.stream(Faculty.values()).anyMatch(facultyEnum -> facultyEnum.name().equals(faculty))){
            throw new InvalidRequestBodyException();
        }

        CharSequence charSequence = "@";
        if ((this.getEmailAddress() == null) || (!this.getEmailAddress().contains(charSequence))) {
            throw new InvalidRequestBodyException();
        }
    }

}
