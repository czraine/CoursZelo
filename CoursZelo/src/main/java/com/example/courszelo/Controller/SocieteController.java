package com.example.courszelo.Controller;


import com.example.courszelo.Service.SocieteService;
import com.example.courszelo.entity.Societe;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Societe")
public class SocieteController {
    private final SocieteService societeService;

    @PostMapping("/addSociete")
    public Societe AddSociete(@RequestBody Societe ch) {
        return societeService.saveEntity(ch);

    }
    @PutMapping("/UpdateSociete")
    public Societe UpdateSociete(@RequestBody Societe ch) {
        return societeService.EditEntity(ch);

    }
    @GetMapping("/retrieve-all")
    public List<Societe> getSociete(){
        List<Societe> societes = societeService.GetALLEntity() ;
        return societes ;
    }
    @GetMapping("/retrieve-all/{Societe-Id}")

    public Societe retieveSociete(@PathVariable("Societe-Id") Long chId ){
        Societe societe= societeService.GetEntity(chId) ;
        return societe ;
    }


    @DeleteMapping("/Delete/{Societe-Id}")
    public void DeleteSociete(@PathVariable("Societe-Id") Long chId ){
        societeService.DeleteEntity(chId);
    }
}
