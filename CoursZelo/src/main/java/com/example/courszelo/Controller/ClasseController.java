package com.example.courszelo.Controller;

import com.example.courszelo.Service.ClasseService;
import com.example.courszelo.entity.Classe;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Classe")
public class ClasseController {
    private final ClasseService classeService;

    @PostMapping("/addClasse")
    public Classe AddClasse(@RequestBody Classe ch) {
        return classeService.saveEntity(ch);

    }
    @PutMapping("/UpdateClasse")
    public Classe UpdateClasse(@RequestBody Classe ch) {
        return classeService.EditEntity(ch);

    }
    @GetMapping("/retrieve-all")
    public List<Classe> getClasse(){
        List<Classe> classes = classeService.GetALLEntity() ;
        return classes ;
    }
    @GetMapping("/retrieve-all/{Classe-Id}")

    public Classe retieveClasse(@PathVariable("Classe-Id") Long chId ){
        Classe classe= classeService.GetEntity(chId) ;
        return classe ;
    }


    @DeleteMapping("/Delete/{Classe-Id}")
    public void DeleteClasse(@PathVariable("Classe-Id") Long chId ){
        classeService.DeleteEntity(chId);
    }
    
}
