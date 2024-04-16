package com.example.courszelo.Service;

import com.example.courszelo.Repository.ModuleRepo;
import com.example.courszelo.Repository.OptionRepo;
import com.example.courszelo.entity.Module;
import com.example.courszelo.entity.Option;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OptionService implements IOptionService {
    private final OptionRepo optionRepo;
    private  final ModuleRepo moduleRepo;

    public Option saveEntity(Option entity) {
        return optionRepo.insert(entity);
    }

    public Option EditEntity(Option entity) {
        return optionRepo.save(entity);
    }

    public List<Option> GetALLEntity() {
        return optionRepo.findAll();
    }

    public Option GetEntity(String id) {
        return optionRepo.findByIdOption(id);
    }

    public void DeleteEntity(String id) {
        optionRepo.deleteById(id);
    }


    public Option addModuleToOption(String optionId, String moduleId) {
        Optional<Option> option = optionRepo.findById(optionId);
        Optional<Module> module = moduleRepo.findById(moduleId);

        if (option.isPresent() && module.isPresent()) {
            Option updatedOption = option.get();
            if (updatedOption.getModules() == null) {
                updatedOption.setModules(new ArrayList<>());
            }
            updatedOption.getModules().add(module.get());
            return optionRepo.save(updatedOption);
        } else {
            throw new RuntimeException("Option or Module not found");
        }

    }

    public Option addOptionWithModules(Option option, List<String> moduleIds) {
        // Enregistrer l'option
        Option savedOption = optionRepo.save(option);

        // Affecter les modules à l'option
        for (String moduleId : moduleIds) {
            Module module = moduleRepo.findById(moduleId).orElseThrow(() -> new IllegalArgumentException("Module non trouvé avec ID: " + moduleId));
            savedOption.getModules().add(module);
        }

        // Mettre à jour l'option avec les modules affectés
        return optionRepo.save(savedOption);
    }

}

