package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "University")
public class University {
    @Id
    private long idUniversity;
    private String nameUniversity;
    private String mailUniversity;
    private int phoneUniversity;
    private String descriptionUniversity;
    private String adresseUniversity;
    @DBRef
    private List<User> students;

    @DBRef
    private List<Departement> departements;



}
