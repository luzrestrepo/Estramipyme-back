package com.project.controllers;


import com.project.models.ActivitiesModel;
import com.project.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public List<ActivitiesModel> getActividades() {
        return actividadService.getActividades();
    }

    @PostMapping
    public ActividadModel saveActividad(@RequestBody ActividadModel actividad) {
        return actividadService.saveActividad(actividad);
    }

    @GetMapping("/{id}")
    public Optional<ActividadModel> getActividadById(@PathVariable Long id) {
        return actividadService.getActividadById(id);
    }

    @PutMapping("/{id}")
    public ActividadModel updateActividadById(@RequestBody ActividadModel actividad, @PathVariable Long id) {
        return actividadService.updateActividadById(actividad, id);
    }

    @DeleteMapping("/{id}")
    public String deleteActividadById(@PathVariable Long id) {
        boolean ok = actividadService.deleteActividad(id);
        return ok ? "Actividad with id " + id + " deleted." : "Error deleting actividad with id " + id;
    }
}

