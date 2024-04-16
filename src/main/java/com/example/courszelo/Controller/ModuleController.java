package com.example.courszelo.Controller;


import com.example.courszelo.Service.ModuleService;
import com.example.courszelo.entity.Module;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/Module")
public class ModuleController {
        private final ModuleService moduleService;

        @PostMapping("/addModule")
        public Module AddModule(@RequestBody Module ch) {
                return moduleService.saveEntity(ch);

        }
//        @PutMapping("/UpdateModule")
//        public Module UpdateModule(@RequestBody Module ch) {
//                return moduleService.EditEntity(ch);
//
//        }

        @PutMapping("/UpdateModule")
        public ResponseEntity<Module> UpdateModule(@RequestBody Module ch){

        Module UpdateModule = moduleService.EditEntity(ch); // Assuming there's a method in userService to modify the user
        return ResponseEntity.ok(UpdateModule);
}



        @GetMapping("/retrieve-all")
        public List<Module> getModule(){
                List<Module> modules = moduleService.GetALLEntity() ;
                return modules ;
        }
        @GetMapping("/retrieve-all/{Module-Id}")

        public Module retieveModule(@PathVariable("Module-Id") String chId ){
                Module module= moduleService.GetEntity(chId) ;
                return module ;
        }


//        @DeleteMapping("/Delete/{Module-Id}")
//        public void DeleteModule(@PathVariable("Module-Id") String chId ){
//                moduleService.DeleteEntity(chId);
//        }

        @DeleteMapping("/Delete/{Module-Id}")
        public ResponseEntity<?> deleteModule(@PathVariable("Module-Id") String moduleId) {
                try {
                        moduleService.DeleteEntity(moduleId);
                        log.info("hello my frienddd");
                        return ResponseEntity.ok().body("Module with ID " + moduleId + " deleted successfully");


                } catch (Exception e) {
                        log.info("byeeee my friendd");
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Module not found with ID: " + moduleId);

                }
        }





}


