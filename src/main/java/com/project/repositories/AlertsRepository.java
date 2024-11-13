package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.models.AlertsModel;

public interface AlertsRepository extends JpaRepository<AlertsModel, Integer> {}
