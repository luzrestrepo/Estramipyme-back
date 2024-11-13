package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.models.AlertsModel;
import com.project.services.AlertsService;

@RestController
@RequestMapping("/alerts")
public class AlertsController {

    @Autowired
    private AlertsService alertsService;

    @GetMapping
    public List<AlertsModel> getAllAlertas() {
        return alertsService.getAllAlerts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertsModel> getAlertaById(@PathVariable int id) {
        return alertsService.getAlertById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AlertsModel createAlerta(@RequestBody AlertsModel alert) {
        return alertsService.createAlert(alert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertsModel> updateAlerta(@PathVariable int id, @RequestBody AlertsModel alerta) {
        try {
            AlertsModel updatedAlerta = alertsService.updateAlert(id, alerta);
            return ResponseEntity.ok(updatedAlerta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable int id) {
        alertsService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}
