package org.example.collegesphere.service;

import org.example.collegesphere.model.Users;
import org.example.collegesphere.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserSerivce {
    private final UserRepo userRepo;

    public UserSerivce(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<Users> get() {
        return userRepo.findAll();
    }


    public Users getID(int id) {
        Optional<Users> users=userRepo.findById(id);
        if(users.isPresent()){
            return users.get();
        }
        return null;
    }

    public Integer add(Users users) {
        Users user=userRepo.save(users);
        return user.getId();
    }

    public Integer update(int id, Users users) {
        Optional<Users> user=userRepo.findById(id);
        if(user.isPresent()){
            userRepo.save(users);
        }
        return null;
    }

    public void delete(int id) {
        userRepo.removeById(id);
    }
}
