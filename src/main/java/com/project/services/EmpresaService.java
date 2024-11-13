package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.models.Empresa;
import com.project.repositories.EmpresaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getEmpresaById(Integer empresaId) {
        return empresaRepository.findById(empresaId);
    }

    public Empresa createEmpresa(Empresa empresa) {
        // Asignar identificación a rut o nit 
        if ("Jurídica".equalsIgnoreCase(empresa.getTipo())) {
            empresa.setNit(empresa.getIdentificacion());
        } else if ("Natural".equalsIgnoreCase(empresa.getTipo())) {
            empresa.setRut(empresa.getIdentificacion());
        }
        empresa.setIdentificacion(null);  // Limpiar el campo temporal 
        return empresaRepository.save(empresa);
    }

    public Empresa updateEmpresa(Integer empresaId, Empresa empresaDetails) {
        return empresaRepository.findById(empresaId).map(empresa -> {
            empresa.setSector(empresaDetails.getSector());
            empresa.setTipo(empresaDetails.getTipo());
            empresa.setNombre(empresaDetails.getNombre());
            empresa.setEmail(empresaDetails.getEmail());
            empresa.setContraseña(empresaDetails.getContraseña());
            empresa.setTamañoEmpresa(empresaDetails.getTamañoEmpresa());

            // Actualizar el nit o rut según el tipo
            if ("Jurídica".equalsIgnoreCase(empresaDetails.getTipo())) {
                empresa.setNit(empresaDetails.getIdentificacion());
                empresa.setRut(null);  
            } else if ("Natural".equalsIgnoreCase(empresaDetails.getTipo())) {
                empresa.setRut(empresaDetails.getIdentificacion());
                empresa.setNit(null);  
            }

            return empresaRepository.save(empresa);
        }).orElse(null);
    }

    public boolean deleteEmpresa(Integer empresaId) {
        return empresaRepository.findById(empresaId).map(empresa -> {
            empresaRepository.delete(empresa);
            return true;
        }).orElse(false);
    }
}
