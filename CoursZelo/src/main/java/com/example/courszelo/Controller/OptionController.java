package com.example.courszelo.Controller;


import com.example.courszelo.Service.OptionService;
import com.example.courszelo.entity.Option;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Option")
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

    public Option retieveOption(@PathVariable("Option-Id") Long chId ){
        Option option= optionService.GetEntity(chId) ;
        return option ;
    }


    @DeleteMapping("/Delete/{Option-Id}")
    public void DeleteOption(@PathVariable("Option-Id") Long chId ){
        optionService.DeleteEntity(chId);
    }
}
