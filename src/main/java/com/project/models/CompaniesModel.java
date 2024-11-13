package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class CompaniesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "professor_id")
    private Integer professorId;

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

    @Column(name = "sector_size", length = 200)
    private String sectorSize;

    @Column(name = "representative", length = 100)
    private String representative;

    @Column(name = "nit", length = 20)
    private String nit;

    @Column(name = "rut", length = 20)
    private String rut;

    @Column(name = "company_size", length = 20)
    private String companySize;

    @Transient  // Temporary field, not stored in the database
    private String identification;

    // Getters and Setters for each field
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getProfessorId() {
        return professorId;
    }
    
    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
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
    
    public String getSectorSize() {
        return sectorSize;
    }
    
    public void setSectorSize(String sectorSize) {
        this.sectorSize = sectorSize;
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
    
    public String getCompanySize() {
        return companySize;
    }
    
    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }
    
    public String getIdentification() {
        return identification;
    }
    
    public void setIdentification(String identification) {
        this.identification = identification;
    }    


}
