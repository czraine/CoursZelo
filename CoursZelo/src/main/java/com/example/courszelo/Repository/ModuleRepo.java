package com.example.courszelo.Repository;

import com.example.courszelo.entity.Classe;
import com.example.courszelo.entity.Departement;
import com.example.courszelo.entity.Module;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends MongoRepository<Module,Long> {
    Module findByIdModule(Long id) ;
}
