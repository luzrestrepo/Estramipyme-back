package com.project.repositories;

import com.project.models.CompaniesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompaniesRepository extends JpaRepository<CompaniesModel, Integer> {

    // Consulta para contar empresas por tipo de usuario
    @Query("SELECT c.typeUser, COUNT(c) FROM CompaniesModel c GROUP BY c.typeUser")
    List<Object[]> countCompaniesByType();

    // Consulta para contar empresas por sector
    @Query("SELECT c.sector, COUNT(c) FROM CompaniesModel c GROUP BY c.sector")
    List<Object[]> countCompaniesBySector();

    // Consulta para contar empresas por tamaño
    @Query("SELECT c.sizeCompany, COUNT(c) FROM CompaniesModel c GROUP BY c.sizeCompany")
    List<Object[]> countCompaniesBySize();

    // Consulta para contar el total de empresas
    long count();

    @Modifying
    @Query("UPDATE CompaniesModel c SET c.isTestDone = :isTestDone WHERE c.id = :companyId")
    void updateTestStatus(@Param("companyId") Integer companyId, @Param("isTestDone") Boolean isTestDone);
}
