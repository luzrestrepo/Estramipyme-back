package com.project.repositories;

import com.project.models.Userito;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Userito, Long> {

    // Definición estándar de búsqueda por nombre de usuario
    static Optional<Userito> findByUsername(String username) {
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    Optional<Userito> findByEmail(String email);
}
