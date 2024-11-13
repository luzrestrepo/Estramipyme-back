package com.project.repositories;

import com.project.models.AnswersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<AnswersModel, Integer> {
}
