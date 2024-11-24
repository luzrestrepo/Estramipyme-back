package com.project.controllers;

import com.project.models.CompaniesModel;
import com.project.services.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
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

    // Endpoint para obtener empresas por tipo
    @GetMapping("/stats/users-by-type")
    public List<Object[]> getUsersByType() {
        return companiesService.countCompaniesByType();
    }

    // Endpoint para obtener empresas por sector
    @GetMapping("/stats/companies-by-sector")
    public List<Object[]> getCompaniesBySector() {
        return companiesService.countCompaniesBySector();
    }

    // Endpoint para obtener empresas por tamaño
    @GetMapping("/stats/companies-by-size")
    public List<Object[]> getCompaniesBySize() {
        return companiesService.countCompaniesBySize();
    }

    // Endpoint para obtener el total de empresas
    @GetMapping("/stats/total-companies")
    public long getTotalCompanies() {
        return companiesService.countTotalCompanies();
    }
//todo lo relacionado a tests
    @PutMapping("/{id}/test-status")
    public ResponseEntity<?> updateTestStatus(
    @PathVariable Integer id,
    @RequestBody Map<String, Boolean> updates
    ) {
        try {
            // Obtener la compañía antes de la actualización
            CompaniesModel currentCompany = companiesService.getCompanyById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

            System.out.println("Compañía antes de actualizar:");
            System.out.println("ID: " + currentCompany.getId());
            System.out.println("Nombre: " + currentCompany.getName());
            System.out.println("Sector: " + currentCompany.getSector());

            // Actualizar solo el estado del test
            CompaniesModel updatedCompany = companiesService.updateTestStatus(id, updates.get("isTestDone"));

            System.out.println("Compañía después de actualizar:");
            System.out.println("ID: " + updatedCompany.getId());
            System.out.println("Nombre: " + updatedCompany.getName());
            System.out.println("Sector: " + updatedCompany.getSector());

            return ResponseEntity.ok(updatedCompany);
        } catch (Exception e) {
            System.err.println("Error en updateTestStatus: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
