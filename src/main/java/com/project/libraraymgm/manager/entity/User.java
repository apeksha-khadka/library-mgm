package com.project.libraraymgm.manager.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int ID;
    private  String firstName;
    private  String lastName;
    private  int semester;
    private  int mattNum;
    private  String faculty;

}
