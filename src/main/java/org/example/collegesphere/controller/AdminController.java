package org.example.collegesphere.controller;

import lombok.RequiredArgsConstructor;
import org.example.collegesphere.exception.AdminNotFoundException;
import org.example.collegesphere.model.Admin;
import org.example.collegesphere.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("admins")
public class AdminController {
    private final AdminService adminService;
    @GetMapping()
    public ResponseEntity<?> getAdmins() {
        return new ResponseEntity<>(adminService.getAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getAdminById(@PathVariable Integer id) throws  AdminNotFoundException{
        return new ResponseEntity<>(adminService.get(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminService.create(admin),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable int id,@RequestBody Admin admin) throws AdminNotFoundException {
        return new ResponseEntity<>(adminService.update(id,admin),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable int id) throws AdminNotFoundException{
        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
