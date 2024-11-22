package com.project.security;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    // Clave secreta que se usará para firmar y verificar el token
    // Tiene que ser mayor a 60 caracteres
    private final String SECRET_KEY = "LaSuperContraseniasuperdupergenialunicaeinigualablelamayorporquesi"; 
    private final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos



    // Generación del token
    public String generateToken(String username, String role) {
        // Usamos la misma SECRET_KEY para firmar el token
        return Jwts.builder()
                .setSubject(username) // Establecemos el usuario como el sujeto
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Fecha de expiración
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Firmamos con la clave secreta
                .compact(); // Compactamos el token
    }

    // Validación del token
    public Boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // Extraemos el nombre de usuario del token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Usamos la misma clave secreta para verificar la firma
                .build()
                .parseClaimsJws(token) // Parseamos el token y obtenemos las claims
                .getBody()
                .getSubject(); // Extraemos el nombre de usuario
    }

    // Extraemos los roles del token
    public String extractRoles(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Usamos la misma clave secreta para verificar la firma
                .build()
                .parseClaimsJws(token) // Parseamos el token y obtenemos las claims
                .getBody()
                .getSubject(); // Extraemos los roles
    }

    // Verificamos si el token ha expirado
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date()); // Comprobamos si la fecha de expiración es anterior a la fecha actual
    }

    // Extraemos la fecha de expiración del token
    private Date extractExpiration(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Usamos la misma clave secreta para verificar la firma
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration(); // Extraemos la fecha de expiración
    }
}