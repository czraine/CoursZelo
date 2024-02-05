package com.example.courszelo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Module")
public class Module {
    @Id
    private long idModule;
    private String nameModule;
    private Date Date;
    private TypeCours typeCours;
    @DBRef
    private Option option ;
    @DBRef
    private List<Classe> classes ;
    @DBRef
    private List<Test> tests ;

}
