package com.project.repositories;

import com.project.models.AdminsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminsRepository extends JpaRepository<AdminsModel, Integer> {
    Optional<AdminsModel> findByEmail(String email); // Método correcto para buscar por email
}
