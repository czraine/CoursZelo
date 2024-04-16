package com.example.courszelo.Repository;

import com.example.courszelo.entity.Classe;
import com.example.courszelo.entity.Option;
import com.example.courszelo.entity.University;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepo extends MongoRepository<University,Long> {
    University findByIdUniversity(Long id) ;
}
