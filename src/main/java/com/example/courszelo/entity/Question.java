package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id; // Importation corrigée
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Questions")
public class Question {
    @Id
    private String id;
    private String questionText;
    private List<String> choices;
    private int correctOptionIndex;
    private int score;



}


