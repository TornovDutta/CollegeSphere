package org.example.collegesphere.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String headOfDepartment;
    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;

}
