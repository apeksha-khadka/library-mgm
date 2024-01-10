package com.project.libraraymgm.manager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"matriculation_number"}),
        @UniqueConstraint(columnNames = {"email_address"}),
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private int matriculationNumber;
    private String emailAddress;
    private String password;

    @Enumerated(EnumType.STRING)
    private Faculty faculty;

    private enum Faculty {
        EI,
        EM,
        PE,
    }
}
