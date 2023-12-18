package com.project.libraraymgm.manager.model;

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
    private long ID;
    private  String firstName;
    private  String lastName;
    private  int semester;
    private  int mattNum;
    private  String faculty;

    @OneToOne
    @JoinColumn(name = "book_name")
    private Book book;




}
