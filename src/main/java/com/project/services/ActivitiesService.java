package com.project.services;

import com.project.models.ActivitiesModel;
import com.project.repositories.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesService {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    public List<ActivitiesModel> getActivities() {
        return activitiesRepository.findAll();
    }

    public ActivitiesModel saveActivities(ActivitiesModel activities) {
        return activitiesRepository.save(activities);
    }

    public Optional<ActivitiesModel> getActivitiesById(Long id) {
        return activitiesRepository.findById(id);
    }

    public ActivitiesModel updateActivitiesById(ActivitiesModel activities, Long id) {
        activities.setId(id);
        return activitiesRepository.save(activities);
    }

    public boolean deleteActivities(Long id) {
        try {
            activitiesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
