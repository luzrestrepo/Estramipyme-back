package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.models.AlertModel;
import com.project.services.AlertasService;

@RestController
@RequestMapping("/alertas")
public class AlertsController {

    @Autowired
    private AlertasService alertasService;

    @GetMapping
    public List<AlertModel> getAllAlertas() {
        return alertasService.getAllAlertas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertModel> getAlertaById(@PathVariable int id) {
        return alertasService.getAlertaById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AlertModel createAlerta(@RequestBody AlertModel alerta) {
        return alertasService.createAlerta(alerta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertModel> updateAlerta(@PathVariable int id, @RequestBody AlertModel alerta) {
        try {
            AlertModel updatedAlerta = alertasService.updateAlerta(id, alerta);
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
