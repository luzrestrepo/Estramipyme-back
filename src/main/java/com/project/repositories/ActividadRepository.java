package com.project.repositories;

import com.project.models.ActividadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActividadRepository extends JpaRepository<ActividadModel, Long> {

}
