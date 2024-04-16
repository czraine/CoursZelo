package com.example.courszelo.Controller;


import com.example.courszelo.Service.UserService;
import com.example.courszelo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/User")
public class UserController {
    private final UserService userService;

    @PostMapping("/addUser")
    public User AddUser(@RequestBody User ch) {
        return userService.saveEntity(ch);

    }
    @PutMapping("/UpdateUser")
    public User UpdateUser(@RequestBody User ch) {
        return userService.EditEntity(ch);

    }
    @GetMapping("/retrieve-all")
    public List<User> getUser(){
        List<User> users = userService.GetALLEntity() ;
        return users ;
    }
    @GetMapping("/retrieve-all/{User-Id}")

    public User retieveUser(@PathVariable("User-Id") Long chId ){
        User user= userService.GetEntity(chId) ;
        return user ;
    }


    @DeleteMapping("/Delete/{User-Id}")
    public void DeleteUser(@PathVariable("User-Id") Long chId ){
        userService.DeleteEntity(chId);
    }
}
