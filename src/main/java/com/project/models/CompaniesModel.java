package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class CompaniesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(name = "sector", length = 100)
    private String sector;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "company_size", length = 20)
    private String companySize;

    @Column(name = "rut", length = 20)
    private String rut;

    @Column(name = "nit", length = 20)
    private String nit;

    // Temporary field to store identification
    @Transient  // Not stored in the database
    private String identification;


    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
