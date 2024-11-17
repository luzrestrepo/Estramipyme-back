package com.project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.models.AuthRequest;
import com.project.models.AuthResponse;
import com.project.models.User;
import com.project.services.AuthService;
import com.project.services.JwtTokenManagerService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenManagerService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        Optional<User> user = authService.authenticate(authRequest);

        if (user.isPresent()) {
            String token = jwtTokenService.generateToken(user.get().getEmail());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
