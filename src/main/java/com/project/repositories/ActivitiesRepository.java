package com.project.repositories;

import com.project.models.ActivitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends JpaRepository<ActivitiesModel, Long> {

}

