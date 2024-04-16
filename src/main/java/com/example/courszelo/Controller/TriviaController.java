package com.example.courszelo.Controller;

import com.example.courszelo.Service.FlaskAPIService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/autoQuiz", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@AllArgsConstructor
@RequestMapping("/api/trivia")
public class TriviaController {

    private final FlaskAPIService flaskAPIService;



    @GetMapping("/categories")
    public ResponseEntity<String> getCategories() {
        return ResponseEntity.ok(flaskAPIService.getCategories());
    }

    @GetMapping("/quiz")
    public ResponseEntity<String> getQuiz(@RequestParam int category,
                                          @RequestParam(defaultValue = "5") int amount,
                                          @RequestParam(defaultValue = "medium") String difficulty,
                                          @RequestParam(defaultValue = "multiple") String type) {
        return ResponseEntity.ok(flaskAPIService.getQuiz(category, amount, difficulty, type));
    }
}
