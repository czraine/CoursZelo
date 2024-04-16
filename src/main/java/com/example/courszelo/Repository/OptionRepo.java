package com.example.courszelo.Repository;

import com.example.courszelo.entity.Classe;
import com.example.courszelo.entity.Module;
import com.example.courszelo.entity.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepo extends MongoRepository<Option,String> {
    Option findByIdOption(String id) ;
}
