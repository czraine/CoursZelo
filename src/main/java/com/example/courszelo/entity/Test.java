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
@Document(collection = "Test")
public class Test {
    @Id
    private long idTest;
    private float noteTest;
    private Date DateTest;
    private TypeTest typeTest;
    private boolean certificat;
    @DBRef
    private List<Module> modules ;
}
