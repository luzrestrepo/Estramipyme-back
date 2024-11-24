package com.project.repositories;

import com.project.models.TestsModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<TestsModel, Integer> {
      Optional<TestsModel> findByCompanyId(Integer companyId);
}
