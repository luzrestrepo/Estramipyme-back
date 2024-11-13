package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.AdminModel;
import com.project.repositories.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminModel> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<AdminModel> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    public AdminModel createAdmin(AdminModel admin) {
        return adminRepository.save(admin);
    }

    public AdminModel updateAdmin(int id, AdminModel admin) {
        return adminRepository.findById(id)
            .map(existingAdmin -> {
                existingAdmin.setNombre(admin.getNombre());
                existingAdmin.setCorreo(admin.getCorreo());
                existingAdmin.setContraseña(admin.getContraseña());
                return adminRepository.save(existingAdmin);
            })
            .orElseThrow(() -> new RuntimeException("Admin no encontrado"));
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }
}
