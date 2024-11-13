package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.AlertsModel;
import com.project.repositories.AlertsRepository;

@Service
public class AlertsService {

    @Autowired
    private AlertsRepository AlertsRepository;

    public List<AlertsModel> getAllAlerts() {
        return AlertsRepository.findAll();
    }

    public Optional<AlertsModel> getAlertById(int id) {
        return AlertsRepository.findById(id);
    }

    public AlertsModel createAlert(AlertsModel alert) {
        return AlertsRepository.save(alert);
    }

    public AlertsModel updateAlert(int id, AlertsModel alert) {
        return AlertsRepository.findById(id)
            .map(existingAlert -> {
                existingAlert.setCompanyId(alert.getCompanyId());
                existingAlert.setType(alert.getType());
                existingAlert.setDescription(alert.getDescription());
                return AlertsRepository.save(existingAlert);
            })
            .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    public void deleteAlert(int id) {
        AlertsRepository.deleteById(id);
    }
}
