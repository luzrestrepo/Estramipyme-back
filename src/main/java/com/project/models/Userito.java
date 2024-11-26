package com.project.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;



@Entity
public class Userito implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    // This method is used to return the password of the user.
    @Override
    public String getUsername() {
        return email;
    }

    // This method is used to check if the user's account is expired or not.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // This method is used to check if the user is locked or not.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // This method is used to check if the user's credentials are expired or not.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // This method is used to check if the user is enabled or not.
    @Override
    public boolean isEnabled() {
        return true;
    }

    // Constructor sin parámetros
    public Userito() {
    }

    // Constructor con todos los parámetros
    public Userito(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

 // Métodos getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}