package com.annamakos.socialcare.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    String surname;
}
