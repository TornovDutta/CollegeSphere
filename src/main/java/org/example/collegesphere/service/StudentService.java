package org.example.collegesphere.service;

import org.example.collegesphere.exception.StudentNotFoundException;
import org.example.collegesphere.exception.UserNotFoundException;
import org.example.collegesphere.model.Student;
import org.example.collegesphere.model.Users;
import org.example.collegesphere.repo.StudentRepo;
import org.example.collegesphere.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo repo;
    private final  UserSerivce userSerivce;
    private final UserRepo userRepo;


    public StudentService(StudentRepo repo, UserSerivce userSerivce,UserRepo userRepo) {
        this.repo = repo;
        this.userSerivce = userSerivce;
        this.userRepo=userRepo;
    }

    public List<Student> get() {
        return repo.findAll();

    }
    public Student getByid(int id) throws  StudentNotFoundException{
        return repo.findById(id).orElseThrow(()->
                new StudentNotFoundException("wrong id"));
    }
    public Student create(Student student){
        Users users=new Users(student.getName(),"0000",student.getEmail(),student.getId());
        userSerivce.add(users);
        return repo.save(student);
    }
    public Student upadte(int id,Student student) throws StudentNotFoundException, UserNotFoundException {
        repo.findById(id).orElseThrow(()->
                new StudentNotFoundException("wrong id"));
        int userid=userRepo.findByName(student.getName());
        Users users=new Users(student.getName(),"0000",student.getEmail(),student.getId());
        userSerivce.update(userid,users);
        return repo.save(student);
    }
    public void delete(int id) throws StudentNotFoundException{
        repo.findById(id).orElseThrow(()->
                new StudentNotFoundException("wrong id"));
        userRepo.removeByRoleId(id);
        repo.removeById(id);

    }
}

