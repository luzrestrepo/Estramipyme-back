package com.project.services;

import com.project.models.User;
import com.project.repositories.UserRepository;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Constructor para inyección de dependencias
    public CustomUserDetailsService(UserRepository userRepository) {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca el usuario por nombre de usuario
        User user = UserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Construye y devuelve un UserDetails
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(((Optional<User>) user.getRoles()).stream()
                        .map(role -> role.getName())  // Asumiendo que Role tiene un método getName()
                        .toArray(String[]::new))     // Convertir roles a un arreglo de Strings
                .build();
    }
}
