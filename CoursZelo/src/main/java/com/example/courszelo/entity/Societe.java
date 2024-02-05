package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Societe")
public class Societe {
    @Id
    private long idSociete;
    private String nameSociete;
    private String mail;
    private int phone;
    private String description;
    private String adresse;
}
