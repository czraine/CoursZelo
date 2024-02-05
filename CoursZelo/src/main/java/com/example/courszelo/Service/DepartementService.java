package com.example.courszelo.Service;

import com.example.courszelo.Repository.DepartementRepo;
import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.entity.Departement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementService implements IDepatementService{
    private final DepartementRepo departementRepo;

    public Departement saveEntity(Departement entity) {
        return departementRepo.insert(entity);
    }
    public Departement EditEntity(Departement entity) {
        return departementRepo.save(entity);
    }
    public List<Departement> GetALLEntity() {
        return departementRepo.findAll();
    }
    public Departement GetEntity(Long id) {
        return departementRepo.findByIdDepartement(id);
    }

    public void DeleteEntity(Long id) {
        departementRepo.deleteById(id);
    }
}
