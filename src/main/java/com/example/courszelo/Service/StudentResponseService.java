package com.example.courszelo.Service;

import com.example.courszelo.Repository.StudentResponseRepo;
import com.example.courszelo.entity.Answer;
import com.example.courszelo.entity.Question;
import com.example.courszelo.entity.Quiz;
import com.example.courszelo.entity.StudentResponse;
import com.example.courszelo.exception.QuizNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentResponseService implements IStudentResponseService {
    private final StudentResponseRepo studentResponseRepository;
    private final QuizService quizService;

    @Override
    public StudentResponse submitResponse(StudentResponse response) {
        Quiz quiz = quizService.getQuizById(response.getQuizId())
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found with id: " + response.getQuizId()));

        // Ici, le score est calculé mais pas enregistré dans la réponse
        calculateScore(quiz, response);

        return studentResponseRepository.save(response);
    }

    public double calculateScore(Quiz quiz, StudentResponse response) {
        double totalScore = 0;
        for (Answer answer : response.getAnswers()) {
            for (Question question : quiz.getQuestions()) {
                if (question.getId().equals(answer.getQuestionId()) &&
                        question.getCorrectOptionIndex() == answer.getSelectedOptionIndex()) {
                    totalScore += question.getScore();
                }
            }
        }
        return totalScore;
    }
}
