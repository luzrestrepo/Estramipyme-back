package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.models.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel, Integer> {}
