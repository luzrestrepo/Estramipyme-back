package com.project.repositories;

import com.project.models.TeachersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeachersRepository extends JpaRepository<TeachersModel, Integer> {
    // Método para encontrar un profesor por su correo electrónico
    Optional<TeachersModel> findByEmail(String email); 
}
