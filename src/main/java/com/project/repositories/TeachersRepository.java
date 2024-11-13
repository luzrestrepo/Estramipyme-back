package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.models.TeacherModel;

public interface TeacherRepository  extends JpaRepository<TeacherModel, Integer>{}
    

