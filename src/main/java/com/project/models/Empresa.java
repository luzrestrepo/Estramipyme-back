package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empresaId;

    @Column(name = "sector", length = 100)
    private String sector;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "contraseña", length = 100)
    private String contraseña;

    @Column(name = "tamaño_empresa", length = 20)
    private String tamañoEmpresa;

    @Column(name = "rut", length = 20)
    private String rut;

    @Column(name = "nit", length = 20)
    private String nit;

    // Campo temporal para almacenar identificación
    @Transient  // No se guarda en la base de datos
    private String identificacion;


    public Integer getID() {
        return empresaId;
    }

    public void setID(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTamañoEmpresa() {
        return tamañoEmpresa;
    }

    public void setTamañoEmpresa(String tamañoEmpresa) {
        this.tamañoEmpresa = tamañoEmpresa;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
