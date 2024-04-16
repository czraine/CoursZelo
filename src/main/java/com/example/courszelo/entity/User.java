package com.example.courszelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "User")
public class User {
    @Id
    private String idUser;
    private String nameUser;
    private String surname;
    private int age;
    private Date dateOfBirth;
    private String adresse;
    private String mail;
    private String password;

    private Role role;
    @JsonIgnore
    @DBRef
    private University university;

}
