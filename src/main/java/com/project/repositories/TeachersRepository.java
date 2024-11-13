package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.models.TeachersModel;

public interface TeachersRepository  extends JpaRepository<TeachersModel, Integer>{}
    

