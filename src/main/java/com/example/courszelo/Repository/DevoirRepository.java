package com.example.courszelo.Repository;

import com.example.courszelo.entity.Devoir;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevoirRepository extends MongoRepository<Devoir, String> {
}
