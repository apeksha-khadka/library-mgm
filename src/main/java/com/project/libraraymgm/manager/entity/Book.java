package com.project.libraraymgm.manager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {


    @Id
    @GeneratedValue
    private long id;
    @Column(name= "bookName")
    private String bookName;
    @Column(name= "authorName")
     private String authorName;


}
