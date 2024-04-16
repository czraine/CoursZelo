package com.example.courszelo.Controller;

import com.example.courszelo.Repository.QuestionRepository;
import com.example.courszelo.Service.IQuizService;
import com.example.courszelo.entity.Quiz;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/Quiz")
public class QuizController {

    private final IQuizService quizService;
    private final QuestionRepository questionRepository;



    // Récupérer tous les quizzes
    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

     //Récupérer un quiz par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String id) {
        return quizService.getQuizById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @GetMapping("/{id}/shuffled")
//    public ResponseEntity<Quiz> getQuizByIdShuffled(@PathVariable String id) {
//        Quiz quiz = quizService.getQuizByIdShuffled(id);
//        return ResponseEntity.ok(quiz);
//    }

    // Créer un nouveau quiz
    @PostMapping("/quizzes")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        // Supposons que quiz contient déjà les questions à enregistrer
        quiz.getQuestions().forEach(question -> {
            if (question.getId() == null) {
                questionRepository.save(question); // Sauvegarde chaque question, MongoDB génère l'id
            }
        });
        Quiz savedQuiz = quizService.createQuiz(quiz);
        return new ResponseEntity<>(savedQuiz, HttpStatus.CREATED);
    }


    // Mettre à jour un quiz existant
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable String id, @Valid @RequestBody Quiz quizDetails) {
        return quizService.updateQuiz(id, quizDetails)
                .map(updatedQuiz -> ResponseEntity.ok(updatedQuiz))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable String id) {
        if (quizService.deleteQuiz(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
