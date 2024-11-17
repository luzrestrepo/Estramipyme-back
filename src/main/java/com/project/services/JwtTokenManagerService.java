package com.project.services;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
    import java.util.HashMap;
    import java.util.Map;

    @SuppressWarnings("unused")
    @Service
public class JwtTokenManagerService {

    private String secretKey = "my_secret_key";  // Asegúrate de usar una clave secreta segura

    @SuppressWarnings("deprecation")
    public String generateToken(String email) {
        return Jwts.builder()
                   .setSubject(email)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + 3600000))  // 1 hora de expiración
                   .signWith(SignatureAlgorithm.HS256, secretKey)
                   .compact();
    }

    @SuppressWarnings("deprecation")
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    @SuppressWarnings("deprecation")
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
