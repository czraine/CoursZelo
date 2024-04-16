package com.example.courszelo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Option")
public class Option {
    @Id
    private String idOption;
    private String nameOption;
    private String mailOption;
    @DBRef
     @JsonIgnore
    List<Module> modules = new ArrayList<>();
}
