package com.example.courszelo.Service;

import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.entity.Test;
import com.example.courszelo.entity.testEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class testService implements ITestService{
    private final TestRepo testRepo;

    public Test saveEntity(Test entity) {
      return testRepo.insert(entity);
    }
    public Test EditEntity(Test entity) {
        return testRepo.save(entity);
    }
    public List<Test> GetALLEntity() {
        return testRepo.findAll();
    }
    public Test GetEntity(Long id) {
        return testRepo.findByIdTest(id);
    }

    public void DeleteEntity(Long id) {
         testRepo.deleteById(id);
    }

}
