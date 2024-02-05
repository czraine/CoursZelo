package com.example.courszelo.Controller;


import com.example.courszelo.Service.UniversityService;
import com.example.courszelo.entity.University;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/University")
public class UniversityController {
    private final UniversityService universityService;

    @PostMapping("/addUniversity")
    public University AddUniversity(@RequestBody University ch) {
        return universityService.saveEntity(ch);

    }
    @PutMapping("/UpdateUniversity")
    public University UpdateUniversity(@RequestBody University ch) {
        return universityService.EditEntity(ch);

    }
    @GetMapping("/retrieve-all")
    public List<University> getUniversity(){
        List<University> universities = universityService.GetALLEntity() ;
        return universities ;
    }
    @GetMapping("/retrieve-all/{University-Id}")

    public University retieveUniversity(@PathVariable("University-Id") Long chId ){
        University university= universityService.GetEntity(chId) ;
        return university ;
    }


    @DeleteMapping("/Delete/{University-Id}")
    public void DeleteUniversity(@PathVariable("University-Id") Long chId ){
        universityService.DeleteEntity(chId);
    }
}
