package com.example.courszelo.Controller;

import com.example.courszelo.Service.StudentResponseService;
import com.example.courszelo.Service.QuizService;
import com.example.courszelo.entity.StudentResponse;
import com.example.courszelo.entity.Quiz;
import com.example.courszelo.exception.QuizNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@RequestMapping("/student-response")
@CrossOrigin
public class StudentResponseController {
    private static final Logger logger = Logger.getLogger(StudentResponseController.class.getName());
    private final StudentResponseService studentResponseService;
    private final QuizService quizService;

    @PostMapping("/responses")
    public ResponseEntity<?> submitResponse(@RequestBody StudentResponse response) {
        logger.info("Received student response: " + response);

        // Validation des données reçues
        if (response.getQuizId() == null || response.getStudentId() == null) {
            return ResponseEntity.badRequest().body("Quiz ID and Student ID must not be null");
        }

        // Récupération et vérification de l'existence du quiz
        Optional<Quiz> quizOptional = quizService.getQuizById(response.getQuizId());
        Quiz quiz = quizOptional.orElseThrow(() -> new QuizNotFoundException("Quiz not found with id: " + response.getQuizId()));

        // Soumission de la réponse de l'étudiant et calcul du score
        StudentResponse savedResponse = studentResponseService.submitResponse(response);
        double score = studentResponseService.calculateScore(quiz, response);

        // Construction de la réponse
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseId", savedResponse.getId());
        responseBody.put("score", score);

        logger.info("Student response submitted with ID: " + savedResponse.getId() + " and calculated score: " + score);

        return ResponseEntity.ok(responseBody);
    }
}
