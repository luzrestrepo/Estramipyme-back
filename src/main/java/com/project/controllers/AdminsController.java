package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.AdminModel;
import com.project.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<AdminModel> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminModel> getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdminModel createAdmin(@RequestBody AdminModel admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminModel> updateAdmin(@PathVariable int id, @RequestBody AdminModel admin) {
        try {
            AdminModel updatedAdmin = adminService.updateAdmin(id, admin);
            return ResponseEntity.ok(updatedAdmin);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
