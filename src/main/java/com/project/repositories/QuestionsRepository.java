package com.project.repositories;

import com.project.models.QuestionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsModel, Integer> {
    
}
