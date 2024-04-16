package com.example.courszelo.Repository;

import com.example.courszelo.entity.DevoirAFaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevoirAFaireRepository extends MongoRepository<DevoirAFaire, String> {
}
