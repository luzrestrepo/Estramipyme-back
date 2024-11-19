package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class CompaniesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "teacher_id")
    private Integer teacherId; // Cambié professorId a teacherId

    @Column(name = "sector", length = 100)
    private String sector;

    @Column(name = "type_user", length = 50)
    private String typeUser;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "representative", length = 100)
    private String representative;

    @Column(name = "nit", length = 20)
    private String nit;

    @Column(name = "rut", length = 20)
    private String rut;

    @Column(name = "size_company", length = 20) // Manteniendo sizeCompany
    private String sizeCompany; // Restauramos sizeCompany

    @Transient
    private String identification;

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getSizeCompany() {
        return sizeCompany;
    }

    public void setSizeCompany(String sizeCompany) {
        this.sizeCompany = sizeCompany;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
