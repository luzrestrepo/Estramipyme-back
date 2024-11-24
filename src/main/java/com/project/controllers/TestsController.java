package com.project.controllers;

import com.project.dto.TestRequestDTO;

import com.project.services.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tests")
@CrossOrigin(origins = "http://localhost:4200")
public class TestsController {

   @Autowired
    private TestsService testsService;

      @GetMapping
    public ResponseEntity<?> getTestByCompanyId(@RequestParam("id") String companyId) {
        try {
            System.out.println("Buscando test para compañía ID: " + companyId);
            TestRequestDTO testDTO = testsService.getTestWithAnswersByCompanyId(companyId);
            return ResponseEntity.ok(testDTO);
        } catch (Exception e) {
            System.err.println("Error buscando test: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createTest(@RequestBody TestRequestDTO testDTO) {
        try {
            System.out.println("Recibiendo nuevo test: " + testDTO);
            TestRequestDTO savedTest = testsService.saveCompleteTest(testDTO);
            return ResponseEntity.ok(savedTest);
        } catch (Exception e) {
            System.err.println("Error creando test: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTest(
        @PathVariable String id, 
        @RequestBody TestRequestDTO testDTO
    ) {
        System.out.println("Actualizando test para company: " + id);
        try {
            TestRequestDTO updatedTest = testsService.updateCompleteTest(id, testDTO);
            System.out.println("Test actualizado exitosamente: " + updatedTest);
            return ResponseEntity.ok(updatedTest);
        } catch (Exception e) {
            System.err.println("Error actualizando test: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}

