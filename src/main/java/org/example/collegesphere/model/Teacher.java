package org.example.collegesphere.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String departments;
    private String designation;
    private String phone;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

}
