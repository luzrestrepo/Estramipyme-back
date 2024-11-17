package com.project.models;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("StudentsModel")
public class StudentsModel extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "professor_id")
    private Integer professorId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "phone", length = 50)
    private String phone;
    
        @SuppressWarnings("unused")
        private Set<String> roles;
    
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
        public String getRoles() {
            return null;  // Ajusta según el diseño de roles para el estudiante
        }
    
        @Override
        public void setRoles(Set<String> roles) {
            this.roles = roles;
	}

	@Override
        public String getUsername() {
            throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
        }
}
