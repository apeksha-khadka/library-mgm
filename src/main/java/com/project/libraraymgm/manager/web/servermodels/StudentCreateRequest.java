package com.project.libraraymgm.manager.web.servermodels;

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

    public  boolean validRequestBody() {
        if (this.getMatriculationNumber() > 99999) {

            return false;
        }
        if (this.getFirstName().length() > 15) {
            return false;
        }
        if (this.getLastName().length() > 15) {
            return false;
        }
        if((this.faculty != null) && Arrays.stream(Faculty.values()).anyMatch(facultyEnum -> facultyEnum.name().equals(faculty))){
            return false;
        }

        CharSequence charSequence = "@";
        if ((this.getEmailAddress() == null) || (!this.getEmailAddress().contains(charSequence))) {
            return false;
        }
          return true;
    }

}
