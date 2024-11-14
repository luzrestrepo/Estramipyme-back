package com.project.controllers;

import com.project.models.TestsModel;
import com.project.services.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tests")
public class TestsController {

    @Autowired
    private TestsService testsService;

    // Get all tests
    @GetMapping
    public List<TestsModel> getAllTests() {
        return testsService.getAllTests();
    }

    // Get test by ID
    @GetMapping("/{id}")
    public Optional<TestsModel> getTestById(@PathVariable Integer id) {
        return testsService.getTestById(id);
    }

    // Create a new test
    @PostMapping
    public TestsModel createTest(@RequestBody TestsModel test) {
        return testsService.createTest(test);
    }

    // Update test by ID
    @PutMapping("/{id}")
    public TestsModel updateTest(@PathVariable Integer id, @RequestBody TestsModel testDetails) {
        return testsService.updateTest(id, testDetails);
    }

    // Delete test by ID
    @DeleteMapping("/{id}")
    public String deleteTest(@PathVariable Integer id) {
        boolean isDeleted = testsService.deleteTest(id);
        return isDeleted ? "Test with ID " + id + " deleted successfully." : "Failed to delete test with ID " + id;
    }
}
