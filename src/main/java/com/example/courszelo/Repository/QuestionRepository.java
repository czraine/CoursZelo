package com.example.courszelo.Repository;

import com.example.courszelo.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    Optional<Question> findById(String id);
}
