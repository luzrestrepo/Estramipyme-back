package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.models.AdminsModel;

public interface AdminRepository extends JpaRepository<AdminsModel, Integer> {}
