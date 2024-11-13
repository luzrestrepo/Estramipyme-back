package com.project.repositories;

import com.project.models.TestsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<TestsModel, Integer> {
}
