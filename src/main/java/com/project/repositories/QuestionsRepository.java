package com.project.repositories;

import com.project.models.QuestionsModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsModel, Integer> {
    List<QuestionsModel> findByTestId(Integer testId);
    void deleteByTestId(Integer testId);
}
