package com.example.courszelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Module")
public class Module {
    @Id
    private String idModule;
    private String nameModule;
    private int credit ;
    @DBRef
    @JsonIgnore
    private List<Subjects> subjects;
    @DBRef
    @JsonIgnore
    private Option option ;
    @DBRef
    @JsonIgnore
    private List<Classe> classes ;
    @DBRef
    @JsonIgnore
    private List<Test> tests ;

}
