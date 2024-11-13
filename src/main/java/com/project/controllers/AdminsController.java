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

import com.project.models.AdminsModel;
import com.project.services.AdminsService;

@RestController
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    private AdminsService adminService;

    @GetMapping
    public List<AdminsModel> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminsModel> getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdminsModel createAdmin(@RequestBody AdminsModel admin) {
        return adminService.createAdmin(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminsModel> updateAdmin(@PathVariable int id, @RequestBody AdminsModel admin) {
        try {
            AdminsModel updatedAdmin = adminService.updateAdmin(id, admin);
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
