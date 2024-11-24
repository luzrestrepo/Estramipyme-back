package com.project.services;

import com.project.models.Userito;
import com.project.models.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private TeachersService teachersService;

    /**
     * Autenticación de usuario por email y contraseña.
     * Primero busca al usuario entre los estudiantes, luego entre los profesores.
     * 
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return Un Optional de User si se encuentra el usuario y la contraseña es válida, de lo contrario, Optional vacío.
     */
    public Optional<Userito> authenticate(String email, String password) {
        // Intentar encontrar al usuario en estudiantes
        Optional<Userito> user = studentsService.findByEmail(email).map(student -> (Userito) student);

        // Si no se encuentra, intentar con profesores
        if (user.isEmpty()) {
            user = teachersService.findByEmail(email).map(teacher -> (Userito) teacher);
        }

        // Filtrar por contraseña
        return user.filter(u -> u.getPassword().equals(password));
    }

    /**
     * Este método está actualmente no implementado.
     * Puede ser utilizado para aceptar una solicitud de autenticación completa (con objeto AuthRequest).
     * 
     * @param authRequest El objeto que contiene las credenciales de autenticación (email y password).
     * @return El mismo tipo de Optional<User> si el proceso de autenticación es exitoso.
     */
    public Optional<Userito> authenticate(AuthRequest authRequest) {
        // Llamada al método anterior usando los datos de AuthRequest
        return authenticate(authRequest.getEmail(), authRequest.getPassword());
    }
}
