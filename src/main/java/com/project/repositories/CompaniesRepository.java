package com.project.repositories;

import com.project.models.CompaniesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<CompaniesModel, Integer> {
    
}



