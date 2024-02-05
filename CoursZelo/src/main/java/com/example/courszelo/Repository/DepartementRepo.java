package com.example.courszelo.Repository;

import com.example.courszelo.entity.Classe;
import com.example.courszelo.entity.Departement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepo extends MongoRepository<Departement,Long> {
    Departement findByIdDepartement(Long id) ;
}
