package org.example.collegesphere.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String role="STUDENT";
    private int roleId;
    public Users(String name,String password,String email,int roleId){
        this.name=name;
        this.password=password;
        this.email=email;
        this.roleId=roleId;
    }

}
