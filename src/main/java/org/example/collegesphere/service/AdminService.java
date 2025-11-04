package org.example.collegesphere.service;

import lombok.RequiredArgsConstructor;
import org.example.collegesphere.exception.AdminNotFoundException;
import org.example.collegesphere.model.Admin;
import org.example.collegesphere.repo.AdminRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepo adminRepo;
    public List<Admin> getAll() {
        return adminRepo.findAll();
    }

    public Admin get(Integer id) throws AdminNotFoundException {
        return adminRepo.findById(id)
                .orElseThrow(() -> new AdminNotFoundException("ID is wrong"));
    }


    public Admin create(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin update(int id, Admin admin) throws AdminNotFoundException{
        Admin newAdmin=adminRepo.findById(id).orElseThrow(()->
                new AdminNotFoundException("id is wrong"));
        newAdmin.setUsrName(admin.getUsrName());
        newAdmin.setPassword(admin.getPassword());
        newAdmin.setEmail(admin.getEmail());
        return adminRepo.save(newAdmin);

    }

    public void delete(int id) throws  AdminNotFoundException{
        adminRepo.findById(id).orElseThrow(()->
                new AdminNotFoundException("wrong id"));
        adminRepo.deleteById(id);
    }
}
