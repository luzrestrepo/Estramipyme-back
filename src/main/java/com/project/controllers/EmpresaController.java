package com.project.controllers;

import com.project.models.EmpresaModel;
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
    public List<EmpresaModel> getAllEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<EmpresaModel> getEmpresaById(@PathVariable Integer empresaId) {
        Optional<EmpresaModel> empresa = empresaService.getEmpresaById(empresaId);
        return empresa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EmpresaModel createEmpresa(@RequestBody EmpresaModel empresa) {
        // Llamamos al servicio para crear la empresa con los datos procesados
        return empresaService.createEmpresa(empresa);
    }

    @PutMapping("/{empresaId}")
    public ResponseEntity<EmpresaModel> updateEmpresa(@PathVariable Integer empresaId, @RequestBody EmpresaModel empresaDetails) {
        EmpresaModel updatedEmpresa = empresaService.updateEmpresa(empresaId, empresaDetails);
        return updatedEmpresa != null ? ResponseEntity.ok(updatedEmpresa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{empresaId}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Integer empresaId) {
        return empresaService.deleteEmpresa(empresaId) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
