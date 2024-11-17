package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.AdminsModel;
import com.project.models.StudentsModel;
import com.project.repositories.AdminsRepository;

@Service
public class AdminsService {

    @Autowired
    private AdminsRepository adminRepository;

    public List<AdminsModel> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<AdminsModel> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    public AdminsModel createAdmin(AdminsModel admin) {
        return adminRepository.save(admin);
    }

    public AdminsModel updateAdmin(int id, AdminsModel admin) {
        return adminRepository.findById(id)
            .map(existingAdmin -> {
                existingAdmin.setName(admin.getName());
                existingAdmin.setEmail(admin.getEmail());
                existingAdmin.setPassword(admin.getPassword());
                return adminRepository.save(existingAdmin);
            })
            .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }

    public Optional<StudentsModel> findByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
}
