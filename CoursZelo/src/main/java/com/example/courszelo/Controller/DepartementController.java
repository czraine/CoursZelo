package com.example.courszelo.Controller;


import com.example.courszelo.Service.DepartementService;
import com.example.courszelo.entity.Departement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Departement")
public class DepartementController {
    private final DepartementService departementService;

    @PostMapping("/addDepartement")
    public Departement AddClasse(@RequestBody Departement ch) {
        return departementService.saveEntity(ch);

    }
    @PutMapping("/UpdateDepartement")
    public Departement UpdateDepartement(@RequestBody Departement ch) {
        return departementService.EditEntity(ch);

    }
    @GetMapping("/retrieve-all")
    public List<Departement> getDepartement(){
        List<Departement> departements = departementService.GetALLEntity() ;
        return departements ;
    }
    @GetMapping("/retrieve-all/{Departement-Id}")

    public Departement retieveDepartement(@PathVariable("Departement-Id") Long chId ){
        Departement departement= departementService.GetEntity(chId) ;
        return departement ;
    }


    @DeleteMapping("/Delete/{Departement-Id}")
    public void DeleteDepartement(@PathVariable("Departement-Id") Long chId ){
        departementService.DeleteEntity(chId);
    }
}
