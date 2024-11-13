package com.project.controllers;

import com.project.models.ActivitiesModel;
import com.project.services.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @GetMapping
    public List<ActivitiesModel> getActivities() {
        return activitiesService.getActivities();
    }

    @PostMapping
    public ActivitiesModel saveActivity(@RequestBody ActivitiesModel activity) {
        return activitiesService.saveActivities(activity);
    }

    @GetMapping("/{id}")
    public Optional<ActivitiesModel> getActivityById(@PathVariable Long id) {
        return activitiesService.getActivitiesById(id);
    }

    @PutMapping("/{id}")
    public ActivitiesModel updateActivityById(@RequestBody ActivitiesModel activity, @PathVariable Long id) {
        return activitiesService.updateActivitiesById(activity, id);
    }

    @DeleteMapping("/{id}")
    public String deleteActivityById(@PathVariable Long id) {
        boolean ok = activitiesService.deleteActivities(id);
        return ok ? "Activity with id " + id + " deleted." : "Error deleting activity with id " + id;
    }
}
