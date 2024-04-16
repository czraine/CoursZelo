package com.example.courszelo.Repository;

import com.example.courszelo.entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {



}
