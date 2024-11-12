package com.project.controllers;

import com.project.models.Empresa;
import com.project.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Integer empresaId) {
        Optional<Empresa> empresa = empresaService.getEmpresaById(empresaId);
        return empresa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        // Llamamos al servicio para crear la empresa con los datos procesados
        return empresaService.createEmpresa(empresa);
    }

    @PutMapping("/{empresaId}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Integer empresaId, @RequestBody Empresa empresaDetails) {
        Empresa updatedEmpresa = empresaService.updateEmpresa(empresaId, empresaDetails);
        return updatedEmpresa != null ? ResponseEntity.ok(updatedEmpresa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{empresaId}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Integer empresaId) {
        return empresaService.deleteEmpresa(empresaId) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
