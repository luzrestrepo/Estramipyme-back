package com.project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.project.models.User;
import com.project.repositories.UserRepository;
import com.project.security.JwtUtil;
import com.project.services.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(CustomUserDetailsService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity.badRequest().body("El cuerpo de la solicitud está vacío.");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("El email no puede estar vacío.");
        }

        // Validar si el email ya está en uso
        if (userService.findUserByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("El email ya está en uso.");
        }

        // Guardar el usuario
        userService.saveUser(user);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        try {
            // Intentar autenticar al usuario
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            // Obtener los detalles del usuario, incluido el rol
            UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
            String role = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElse("USER"); // Asigna "USER" si no hay rol específico

            // Generar JWT con el rol
            String jwtToken = jwtUtil.generateToken(user.getUsername(), role);

            // Devolver el JWT al usuario
            return ResponseEntity.ok("Bearer " + jwtToken);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Credenciales inválidas.");
        }
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<User> getUserProfile(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}