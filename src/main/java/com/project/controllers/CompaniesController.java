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

    @GetMapping("/{id}")
    public ResponseEntity<CompaniesModel> getCompanyById(@PathVariable Integer id) {
        Optional<CompaniesModel> company = companiesService.getCompanyById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompaniesModel createCompany(@RequestBody CompaniesModel company) {
        return companiesService.createCompany(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompaniesModel> updateCompany(@PathVariable Integer id, @RequestBody CompaniesModel companyDetails) {
        CompaniesModel updatedCompany = companiesService.updateCompany(id, companyDetails);
        return updatedCompany != null ? ResponseEntity.ok(updatedCompany) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Integer id) {
        boolean deleted = companiesService.deleteCompany(id);
        return deleted ? ResponseEntity.ok("Company with id " + id + " deleted.") : ResponseEntity.notFound().build();
    }
}
