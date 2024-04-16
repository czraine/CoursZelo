package com.example.courszelo.Repository;

import com.example.courszelo.entity.Test;
import com.example.courszelo.entity.testEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.TimeZone;

@Repository

public interface TestRepo extends MongoRepository<Test,Long> {
    Test findByIdTest(Long id) ;
}
