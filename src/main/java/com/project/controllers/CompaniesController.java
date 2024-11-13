package com.project.controllers;

import com.project.models.CompaniesModel;
import com.project.services.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private CompaniesService companiesService;

    @GetMapping
    public List<CompaniesModel> getAllCompanies() {
        return companiesService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompaniesModel> getCompanyById(@PathVariable Integer companyId) {
        Optional<CompaniesModel> company = companiesService.getCompanyById(companyId);
        return company.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompaniesModel createCompany(@RequestBody CompaniesModel company) {
        // Call the service to create the company with the processed data
        return companiesService.createCompany(company);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompaniesModel> updateCompany(@PathVariable Integer companyId, @RequestBody CompaniesModel companyDetails) {
        CompaniesModel updatedCompany = companiesService.updateCompany(companyId, companyDetails);
        return updatedCompany != null ? ResponseEntity.ok(updatedCompany) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer companyId) {
        return companiesService.deleteCompany(companyId) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

