package com.example.courszelo.Service;

import com.example.courszelo.Repository.ClasseRepo;
import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.entity.Classe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasseService implements IClasseService{
    private final ClasseRepo classeRepo;

    public Classe saveEntity(Classe entity) {
        return classeRepo.insert(entity);
    }
    public Classe EditEntity(Classe entity) {
        return classeRepo.save(entity);
    }
    public List<Classe> GetALLEntity() {
        return classeRepo.findAll();
    }
    public Classe GetEntity(Long id) {
        return classeRepo.findByIdClasse(id);
    }

    public void DeleteEntity(Long id) {
        classeRepo.deleteById(id);
    }
}
