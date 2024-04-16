package com.example.courszelo.Controller;


import com.example.courszelo.Service.OptionService;
import com.example.courszelo.entity.Option;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/Option")
public class OptionController {
    private final OptionService optionService;

    @PostMapping("/addOption")
    public Option AddOption(@RequestBody Option ch) {
        return optionService.saveEntity(ch);

    }
    @PutMapping("/UpdateOption")
    public Option UpdateOption(@RequestBody Option ch) {
        return optionService.EditEntity(ch);

    }
    @GetMapping("/retrieve-all")
    public List<Option> getOption(){
        List<Option> options = optionService.GetALLEntity() ;
        return options ;
    }
    @GetMapping("/retrieve-all/{Option-Id}")

    public Option retieveOption(@PathVariable("Option-Id") String chId ){
        Option option= optionService.GetEntity(chId) ;
        return option ;
    }


    @DeleteMapping("/Delete/{Option-Id}")
    public void DeleteOption(@PathVariable("Option-Id") String chId ){
        optionService.DeleteEntity(chId);
    }

    @PostMapping("/{optionId}/addModule/{moduleId}")
    public Option addModuleToOption(@PathVariable String optionId, @PathVariable String moduleId) {
        return optionService.addModuleToOption(optionId, moduleId);
    }

    @PostMapping("/addOptionWithModules")
    public Option addOptionWithModules(@RequestBody Option option, @RequestParam List<String> moduleIds) {
        return optionService.addOptionWithModules(option, moduleIds);
    }

}
