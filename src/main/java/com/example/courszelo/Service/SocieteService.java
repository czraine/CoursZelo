package com.example.courszelo.Service;

import com.example.courszelo.Repository.SocieteRepo;
import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.entity.Societe;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SocieteService implements ISocieteService{
    private final SocieteRepo societeRepo;

    public Societe saveEntity(Societe entity) {
        return societeRepo.insert(entity);
    }
    public Societe EditEntity(Societe entity) {
        return societeRepo.save(entity);
    }
    public List<Societe> GetALLEntity() {
        return societeRepo.findAll();
    }
    public Societe GetEntity(Long id) {
        return societeRepo.findByIdSociete(id);
    }

    public void DeleteEntity(Long id) {
        societeRepo.deleteById(id);
    }
}
