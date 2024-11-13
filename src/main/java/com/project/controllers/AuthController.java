package com.project.controllers;

import com.project.security.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Simulación de autenticación; valida las credenciales contra la base de datos
        if ("user@example.com".equals(authRequest.getEmail()) && "password123".equals(authRequest.getPassword())) {
                            String token = jwtTokenService.generateToken(authRequest.getEmail(), "USER");
                            return ResponseEntity.ok(new AuthResponse(token));
                        } else {
                            return ResponseEntity.status(401).body("Credenciales inválidas");
                        }
                    }
                }
                
                class AuthRequest {
                    @SuppressWarnings("unused")
                    private String email;
                    @SuppressWarnings("unused")
                    private String password;
                    public Object getEmail() {
                        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
                    }
                    public Object getPassword() {
                        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
                    }

    // Getters y setters
}

class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
