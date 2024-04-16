package com.example.courszelo.Service;

import com.example.courszelo.Repository.QuestionRepository;
import com.example.courszelo.entity.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {
    private final QuestionRepository questionRepository;

    public Question saveEntity(Question entity) {
        return questionRepository.insert(entity);
    }
    public Question EditEntity(Question entity) {
        return questionRepository.save(entity);
    }
    public List<Question> GetALLEntity() {
        return questionRepository.findAll();
    }
    public Optional<Question> GetEntity(String id) {
        return questionRepository.findById(id);
    }

    public void DeleteEntity(String id) {
        questionRepository.deleteById(id);
    }




}
