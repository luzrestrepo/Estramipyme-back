package com.project.repositories;

import com.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Definir el método estático correctamente
    static Optional<User> findByUsername(String username) {
        // Tu implementación para encontrar el usuario por nombre de usuario, por ejemplo:
        // return findByUsernameFromDatabase(username);
        return Optional.empty();  // Ejemplo de implementación (deberías reemplazarlo con la implementación real)
    }
}
