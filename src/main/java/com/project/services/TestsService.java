package com.project.services;

import com.project.models.TestsModel;
import com.project.repositories.TestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestsService {

    @Autowired
    private TestsRepository testsRepository;

    // Get all tests
    public List<TestsModel> getAllTests() {
        return testsRepository.findAll();
    }

    // Get a single test by ID
    public Optional<TestsModel> getTestById(Integer id) {
        return testsRepository.findById(id);
    }

    // Create a new test
    public TestsModel createTest(TestsModel test) {
        return testsRepository.save(test);
    }

    // Update an existing test by ID
    public TestsModel updateTest(Integer id, TestsModel testDetails) {
        return testsRepository.findById(id).map(test -> {
            test.setCompanyId(testDetails.getCompanyId());
            test.setDate(testDetails.getDate());
            return testsRepository.save(test);
        }).orElse(null);
    }

    // Delete a test by ID
    public boolean deleteTest(Integer id) {
        return testsRepository.findById(id).map(test -> {
            testsRepository.delete(test);
            return true;
        }).orElse(false);
    }
}
