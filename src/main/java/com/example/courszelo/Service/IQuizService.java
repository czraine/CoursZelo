package com.example.courszelo.Service;

import com.example.courszelo.entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface IQuizService {
    List<Quiz> getAllQuizzes();
    Optional<Quiz> getQuizById(String id);
    //public Quiz getQuizByIdShuffled(String id);

    Optional<Quiz> updateQuiz(String id, Quiz updatedQuiz);
    boolean deleteQuiz(String id);

    Quiz createQuiz(Quiz quiz);
}
