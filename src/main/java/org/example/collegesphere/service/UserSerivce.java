package org.example.collegesphere.service;

import org.example.collegesphere.exception.UserNotFoundException;
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


    public Users getID(int id) throws UserNotFoundException {
        return  userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
    }

    public Integer add(Users users) {
        Users user=userRepo.save(users);
        return user.getId();
    }

    public Integer update(int id, Users users) throws UserNotFoundException {
        Users user=userRepo.findById(id).orElseThrow(()->
                new UserNotFoundException("User with "+id+"not found"));
        return userRepo.save(user).getId();
    }

    public void delete(int id) throws UserNotFoundException{
        Users user=userRepo.findById(id).orElseThrow(()->
                new UserNotFoundException("user of id: "+id+" not found"));
        userRepo.removeById(id);

    }
}
