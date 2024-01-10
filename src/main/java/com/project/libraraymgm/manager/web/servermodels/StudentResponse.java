package com.project.libraraymgm.manager.web.servermodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
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


}
