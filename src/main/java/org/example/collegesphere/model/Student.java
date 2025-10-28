package org.example.collegesphere.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String rollNumber;
    private String gender;
    private String department;
    private String session;
    private String phoneNo;
    private String address;
    @ManyToOne
    private Course course;

}
