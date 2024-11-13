package com.project.services;

import com.project.models.ActividadModel;
import com.project.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    public List<ActividadModel> getActividades() {
        return actividadRepository.findAll();
    }

    public ActividadModel saveActividad(ActividadModel actividad) {
        return actividadRepository.save(actividad);
    }

    public Optional<ActividadModel> getActividadById(Long id) {
        return actividadRepository.findById(id);
    }

    public ActividadModel updateActividadById(ActividadModel actividad, Long id) {
        actividad.setId(id);
        return actividadRepository.save(actividad);
    }

    public boolean deleteActividad(Long id) {
        try {
            actividadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
