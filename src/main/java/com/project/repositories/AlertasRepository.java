package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.models.AlertModel;

public interface AlertasRepository extends JpaRepository<AlertModel, Integer> {}
