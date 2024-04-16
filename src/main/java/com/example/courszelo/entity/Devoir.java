package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Devoir")
public class Devoir {
    @Id
    private String id;
    private String titre;
    private String description;
    private Date dateEcheance;
    private String cheminFichierPDF;
}
