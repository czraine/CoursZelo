package com.example.courszelo.Service;

import com.example.courszelo.Repository.ModuleRepo;
import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.entity.Module;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModuleService implements IModuleService{
    private final ModuleRepo moduleRepo;

    public Module saveEntity(Module entity) {
        return moduleRepo.insert(entity);
    }
    public Module EditEntity(Module entity) {
        return moduleRepo.save(entity);
    }
    public List<Module> GetALLEntity() {
        return moduleRepo.findAll();
    }
    public Module GetEntity(Long id) {
        return moduleRepo.findByIdModule(id);
    }

    public void DeleteEntity(Long id) {
        moduleRepo.deleteById(id);
    }
}
