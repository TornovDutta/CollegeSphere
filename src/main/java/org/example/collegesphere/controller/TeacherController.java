package org.example.collegesphere.controller;

import lombok.RequiredArgsConstructor;
import org.example.collegesphere.exception.AdminNotFoundException;
import org.example.collegesphere.exception.TeacherNotFoundException;
import org.example.collegesphere.model.Admin;
import org.example.collegesphere.model.Teacher;
import org.example.collegesphere.service.Teacherservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final Teacherservice teacherservice;
    @GetMapping()
    public ResponseEntity<?> getTeachers() {
        return new ResponseEntity<>(teacherservice.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Long id) throws TeacherNotFoundException {
        return new ResponseEntity<>(teacherservice.get(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherservice.create(teacher),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id,@RequestBody Teacher teacher) throws TeacherNotFoundException {
        return new ResponseEntity<>(teacherservice.update(id,teacher),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Long id) throws TeacherNotFoundException{
        teacherservice.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
