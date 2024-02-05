package com.example.courszelo.Controller;

import com.example.courszelo.Service.testService;
import com.example.courszelo.entity.Test;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class testController {
    private final testService testService;
    @PostMapping("/addtest")
    public Test Addtest(@RequestBody Test ch) {
        return testService.saveEntity(ch);

    }
    @PutMapping("/Updatetest")
    public Test Updatetest(@RequestBody Test ch) {
        return testService.EditEntity(ch);

    }
    @GetMapping("/retrieve-all")
    public List<Test> gettest(){
        List<Test> tests = testService.GetALLEntity() ;
        return tests ;
    }
    @GetMapping("/retrieve-all/{test-id}")

    public Test retievetest(@PathVariable("test-id") Long chId ){
        Test test= testService.GetEntity(chId) ;
        return test ;
    }


    @DeleteMapping("/Delete/{test-id}")
    public void Deletetest(@PathVariable("test-id") Long chId ){
        testService.DeleteEntity(chId);
    }

}
