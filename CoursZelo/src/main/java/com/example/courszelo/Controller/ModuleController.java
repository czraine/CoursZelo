package com.example.courszelo.Controller;


import com.example.courszelo.Service.ModuleService;
import com.example.courszelo.entity.Module;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Module")
public class ModuleController {
        private final ModuleService moduleService;

        @PostMapping("/addModule")
        public Module AddModule(@RequestBody Module ch) {
                return moduleService.saveEntity(ch);

        }
        @PutMapping("/UpdateModule")
        public Module UpdateModule(@RequestBody Module ch) {
                return moduleService.EditEntity(ch);

        }
        @GetMapping("/retrieve-all")
        public List<Module> getModule(){
                List<Module> modules = moduleService.GetALLEntity() ;
                return modules ;
        }
        @GetMapping("/retrieve-all/{Module-Id}")

        public Module retieveModule(@PathVariable("Module-Id") Long chId ){
                Module module= moduleService.GetEntity(chId) ;
                return module ;
        }


        @DeleteMapping("/Delete/{Module-Id}")
        public void DeleteModule(@PathVariable("Module-Id") Long chId ){
                moduleService.DeleteEntity(chId);
        }
}
