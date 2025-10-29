package org.example.collegesphere.service;

import org.example.collegesphere.model.Users;
import org.example.collegesphere.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerivce {
    private final UserRepo userRepo;

    public UserSerivce(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<Users> get() {
        return userRepo.findAll();
    }


}
