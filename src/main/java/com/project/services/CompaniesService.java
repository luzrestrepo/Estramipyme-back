package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.models.CompaniesModel;
import com.project.repositories.CompaniesRepository;

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
        // Assign identification to rut or nit
        if ("Jurídica".equalsIgnoreCase(company.getTypeUser())) {
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
            company.setSizeCompany(companyDetails.getSizeCompany()); // Asegúrate de actualizar sizeCompany

            if ("Jurídica".equalsIgnoreCase(companyDetails.getTypeUser())) {
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
}
