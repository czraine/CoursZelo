package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Courses")
public class Courses {
    @Id
    private String id;
    private String 	COURSE_NAME;
    private Double 	RATTINGS;
    private String 	COMPANY;
}
