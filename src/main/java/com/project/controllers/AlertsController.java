package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.models.AlertasModel;
import com.project.services.AlertasService;

@RestController
@RequestMapping("/alertas")
public class AlertasController {

    @Autowired
    private AlertasService alertasService;

    @GetMapping
    public List<AlertasModel> getAllAlertas() {
        return alertasService.getAllAlertas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertasModel> getAlertaById(@PathVariable int id) {
        return alertasService.getAlertaById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AlertasModel createAlerta(@RequestBody AlertasModel alerta) {
        return alertasService.createAlerta(alerta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertasModel> updateAlerta(@PathVariable int id, @RequestBody AlertasModel alerta) {
        try {
            AlertasModel updatedAlerta = alertasService.updateAlerta(id, alerta);
            return ResponseEntity.ok(updatedAlerta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable int id) {
        alertasService.deleteAlerta(id);
        return ResponseEntity.noContent().build();
    }
}
