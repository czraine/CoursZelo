package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "StudentResponse")
public class StudentResponse {
    @Id
    private String id;
    private String studentId;
    private String quizId;
    private List<Answer> answers;


}
