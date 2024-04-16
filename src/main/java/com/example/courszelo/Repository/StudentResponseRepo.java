package com.example.courszelo.Repository;


import com.example.courszelo.entity.StudentResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentResponseRepo extends MongoRepository<StudentResponse,Long> {

}
