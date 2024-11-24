package com.project.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TeachersModel") // Asegúrate de que esto coincida con el valor en la base de datos
public class TeachersModel extends Userito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @SuppressWarnings("unused")
    private String role;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRole() {
        return null; // Ajusta según el diseño de roles para el profesor
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }
}
