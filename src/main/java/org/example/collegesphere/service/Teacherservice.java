package org.example.collegesphere.service;

import lombok.RequiredArgsConstructor;
import org.example.collegesphere.exception.AdminNotFoundException;
import org.example.collegesphere.exception.TeacherNotFoundException;
import org.example.collegesphere.model.Admin;
import org.example.collegesphere.model.Teacher;
import org.example.collegesphere.repo.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Teacherservice {
    private final TeacherRepo teacherRepo;
    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    public Teacher get(Long id) throws TeacherNotFoundException {
        return teacherRepo.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("ID is wrong"));
    }


    public Teacher create(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Teacher update(Long id, Teacher teacher) throws TeacherNotFoundException{
        Teacher newTeacher= teacherRepo.findById(id).orElseThrow(()->
                new TeacherNotFoundException("id is wrong"));
        newTeacher.setCourses(teacher.getCourses());
        newTeacher.setName(teacher.getName());
        newTeacher.setEmail(teacher.getEmail());
        newTeacher.setPhone(teacher.getPhone());
        newTeacher.setDepartment(teacher.getDepartment());

        return teacherRepo.save(newTeacher);

    }

    public void delete(Long id) throws  TeacherNotFoundException{
        teacherRepo.findById(id).orElseThrow(()->
                new TeacherNotFoundException("wrong id"));
        teacherRepo.deleteById(id);
    }
}
