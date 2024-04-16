package com.example.courszelo.Service;

import com.example.courszelo.Repository.TestRepo;
import com.example.courszelo.Repository.UserRepo;
import com.example.courszelo.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    private final UserRepo userRepo;

    public User saveEntity(User entity) {
        return userRepo.insert(entity);
    }
    public User EditEntity(User entity) {
        return userRepo.save(entity);
    }
    public List<User> GetALLEntity() {
        return userRepo.findAll();
    }
    public User GetEntity(Long id) {
        return userRepo.findByIdUser(id);
    }

    public void DeleteEntity(Long id) {
        userRepo.deleteById(id);
    }
}
