package org.example.collegesphere.controller;

import org.example.collegesphere.exception.ErrorResponse;
import org.example.collegesphere.exception.UserNotFoundException;
import org.example.collegesphere.model.Users;
import org.example.collegesphere.service.UserSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserSerivce service;

    public UserController(UserSerivce service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Users>> getAll(){
        try{
            return new ResponseEntity<>(service.get(), HttpStatus.OK);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws UserNotFoundException{

        return new ResponseEntity<>(service.getID(id), HttpStatus.OK);


    }
    @PostMapping()
    public ResponseEntity<Integer> create(@RequestBody Users users){
        try{
            return new ResponseEntity<>(service.add(users),HttpStatus.CREATED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@PathVariable int id,@RequestBody Users users) throws UserNotFoundException{
        return new ResponseEntity<>(service.update(id,users),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) throws UserNotFoundException{
       service.delete(id);
       return new ResponseEntity<>("delete the "+id+"user",HttpStatus.NO_CONTENT);
    }



}
