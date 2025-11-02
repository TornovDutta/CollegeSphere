package org.example.collegesphere.controller;

import lombok.RequiredArgsConstructor;
import org.example.collegesphere.exception.StudentNotFoundException;
import org.example.collegesphere.exception.UserNotFoundException;
import org.example.collegesphere.model.Student;
import org.example.collegesphere.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;



    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(service.get(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> makeStudent(Student s){
        return new ResponseEntity<>(service.create(s),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> upadteStudent(int id,Student student) throws StudentNotFoundException, UserNotFoundException {
        return new ResponseEntity<>(service.upadte(id,student),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(int id) throws StudentNotFoundException{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
