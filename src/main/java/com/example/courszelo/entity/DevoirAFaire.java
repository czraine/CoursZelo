package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "DevoirAFaire")
public class DevoirAFaire {
    String id;
    String titre;
    String description;
    Date dateEcheance;
    String cheminFichierPDF;

}