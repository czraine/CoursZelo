package com.example.courszelo.Repository;

import com.example.courszelo.entity.Classe;
import com.example.courszelo.entity.testEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepo extends MongoRepository<Classe,Long> {
    Classe findByIdClasse(long id) ;
}
