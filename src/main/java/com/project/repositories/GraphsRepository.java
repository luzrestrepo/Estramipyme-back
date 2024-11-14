package com.project.repositories;

import com.project.models.GraphsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphsRepository extends JpaRepository<GraphsModel, Integer> {
    // You can add custom queries if needed, for example, to find by test_id
}
