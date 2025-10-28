package org.example.collegesphere.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

    private Float mark;
}
