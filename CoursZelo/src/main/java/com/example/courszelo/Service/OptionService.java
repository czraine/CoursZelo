package com.example.courszelo.Service;

import com.example.courszelo.Repository.OptionRepo;
import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.entity.Option;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionService implements IOptionService{
    private final OptionRepo optionRepo;

    public Option saveEntity(Option entity) {
        return optionRepo.insert(entity);
    }
    public Option EditEntity(Option entity) {
        return optionRepo.save(entity);
    }
    public List<Option> GetALLEntity() {
        return optionRepo.findAll();
    }
    public Option GetEntity(Long id) {
        return optionRepo.findByIdOption(id);
    }

    public void DeleteEntity(Long id) {
        optionRepo.deleteById(id);
    }
}
