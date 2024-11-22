package com.project.services;

import com.project.models.User;
import com.project.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        // Constructor para inyección de dependencias
        @Autowired
        public CustomUserDetailsService(UserRepository userRepository,@Lazy PasswordEncoder passwordEncoder) {

                this.userRepository = userRepository;
                this.passwordEncoder = passwordEncoder;
        }

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                // Busca el usuario por nombre de usuario
                User user = userRepository.findByEmail(email)
                                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

                // Construye y devuelve un UserDetails
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                                new ArrayList<>());
        }

        public Optional<User> findUserByEmail(String email) {
                return userRepository.findByEmail(email);
            }
        public User saveUser(User user) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                return userRepository.save(user);
            }
}
