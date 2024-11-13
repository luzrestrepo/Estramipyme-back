package com.project.services;

import org.springframework.stereotype.Service;


/* 
import java.util.Date;
    import java.util.HashMap;
    import java.util.Map;
 */   
    @Service
    public class JwtTokenManagerService {
    
       /*  private final String SECRET_KEY = "yourSecretKey";  // Debes almacenar esta clave de forma segura
    
        @SuppressWarnings("deprecation")
        public String generateToken(String username, String role) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("role", role);
    
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(username)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        } */
    }
