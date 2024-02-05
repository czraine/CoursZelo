package com.example.courszelo.Repository;

import com.example.courszelo.entity.Classe;
import com.example.courszelo.entity.Option;
import com.example.courszelo.entity.Societe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteRepo extends MongoRepository<Societe,Long> {
    Societe findByIdSociete(Long id) ;
}
