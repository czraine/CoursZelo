package com.example.courszelo.Service;

import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.Repository.UniversityRepo;
import com.example.courszelo.entity.University;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversityService implements IUniversityService{
    private final UniversityRepo universityRepo;

    public University saveEntity(University entity) {
        return universityRepo.insert(entity);
    }
    public University EditEntity(University entity) {
        return universityRepo.save(entity);
    }
    public List<University> GetALLEntity() {
        return universityRepo.findAll();
    }
    public University GetEntity(Long id) {
        return universityRepo.findByIdUniversity(id);
    }

    public void DeleteEntity(Long id) {
        universityRepo.deleteById(id);
    }
}
