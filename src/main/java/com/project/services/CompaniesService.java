package com.project.services;

import com.project.models.CompaniesModel;
import com.project.repositories.CompaniesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompaniesService {

    @Autowired
    private CompaniesRepository companiesRepository;

    public List<CompaniesModel> getAllCompanies() {
        return companiesRepository.findAll();
    }

    public Optional<CompaniesModel> getCompanyById(Integer companyId) {
        return companiesRepository.findById(companyId);
    }

    public CompaniesModel createCompany(CompaniesModel company) {
        if ("Legal".equalsIgnoreCase(company.getTypeUser())) {
            company.setNit(company.getIdentification());
        } else if ("Natural".equalsIgnoreCase(company.getTypeUser())) {
            company.setRut(company.getIdentification());
        }
        company.setIdentification(null);
        return companiesRepository.save(company);
    }

    public CompaniesModel updateCompany(Integer companyId, CompaniesModel companyDetails) {
        return companiesRepository.findById(companyId).map(company -> {
            company.setTeacherId(companyDetails.getTeacherId());
            company.setSector(companyDetails.getSector());
            company.setTypeUser(companyDetails.getTypeUser());
            company.setName(companyDetails.getName());
            company.setEmail(companyDetails.getEmail());
            company.setPassword(companyDetails.getPassword());
            company.setRepresentative(companyDetails.getRepresentative());
            company.setSizeCompany(companyDetails.getSizeCompany());

            if ("Legal".equalsIgnoreCase(companyDetails.getTypeUser())) {
                company.setNit(companyDetails.getIdentification());
                company.setRut(null);
            } else if ("Natural".equalsIgnoreCase(companyDetails.getTypeUser())) {
                company.setRut(companyDetails.getIdentification());
                company.setNit(null);
            }

            return companiesRepository.save(company);
        }).orElse(null);
    }

    public boolean deleteCompany(Integer companyId) {
        return companiesRepository.findById(companyId).map(company -> {
            companiesRepository.delete(company);
            return true;
        }).orElse(false);
    }

    // Método para obtener empresas por tipo de usuario
    public List<Object[]> countCompaniesByType() {
        return companiesRepository.countCompaniesByType();
    }

    // Método para obtener empresas por sector
    public List<Object[]> countCompaniesBySector() {
        return companiesRepository.countCompaniesBySector();
    }

    // Método para obtener empresas por tamaño
    public List<Object[]> countCompaniesBySize() {
        return companiesRepository.countCompaniesBySize();
    }

    // Método para contar el total de empresas
    public long countTotalCompanies() {
        return companiesRepository.count();
    }
//solo agregue tdo lo relacionado  a tests
    @Transactional
        public CompaniesModel updateTestStatus(Integer companyId, Boolean isTestDone) {
        CompaniesModel existingCompany = companiesRepository.findById(companyId)
            .orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));

        // Ejecutar update específico solo para is_test_done
        companiesRepository.updateTestStatus(companyId, isTestDone);
        
        // Retornar la compañía actualizada
        return companiesRepository.findById(companyId).orElseThrow();
    }
}
