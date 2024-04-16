package com.example.courszelo.Service;

import com.example.courszelo.Repository.QuizRepository;
import com.example.courszelo.entity.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class QuizService  implements  IQuizService{


    private final QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Optional<Quiz> getQuizById(String id) {
        return quizRepository.findById(id);
    }
//public Quiz getQuizByIdShuffled(String id) {
//    return quizRepository.findById(id)
//            .map(quiz -> {
//                Collections.shuffle(quiz.getQuestions()); // Assurez-vous que getQuestions() retourne une liste modifiable
//                return quiz;
//            }).orElseThrow(() -> new RuntimeException("Quiz not found with id " + id));
//}


    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @Transactional
    public Optional<Quiz> updateQuiz(String id, Quiz updatedQuiz) {
        return quizRepository.findById(id)
                .map(quiz -> {
                    quiz.setTitle(updatedQuiz.getTitle());
                    quiz.setQuestions(updatedQuiz.getQuestions());
                    return quizRepository.save(quiz);
                });
    }

    public boolean deleteQuiz(String id) {
        quizRepository.deleteById(id);
        return false;
    }

}
