package com.project.repositories;

import com.project.models.StudentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<StudentsModel, Long> {
    Optional<StudentsModel> findByEmail(String email); // Método correcto para buscar por email
}
