package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.AlertModel;
import com.project.repositories.AlertasRepository;

@Service
public class AlertasService {

    @Autowired
    private AlertasRepository alertasRepository;

    public List<AlertModel> getAllAlertas() {
        return alertasRepository.findAll();
    }

    public Optional<AlertModel> getAlertaById(int id) {
        return alertasRepository.findById(id);
    }

    public AlertModel createAlerta(AlertModel alerta) {
        return alertasRepository.save(alerta);
    }

    public AlertModel updateAlerta(int id, AlertModel alerta) {
        return alertasRepository.findById(id)
            .map(existingAlerta -> {
                existingAlerta.setEmpresaId(alerta.getEmpresaId());
                existingAlerta.setTipo(alerta.getTipo());
                existingAlerta.setDescripcion(alerta.getDescripcion());
                return alertasRepository.save(existingAlerta);
            })
            .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));
    }

    public void deleteAlerta(int id) {
        alertasRepository.deleteById(id);
    }
}
