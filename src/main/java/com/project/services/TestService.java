package com.project.services;

import com.project.models.TestModel;
import com.project.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<TestModel> getAllTests() {
        return testRepository.findAll();
    }

    public Optional<TestModel> getTestById(int id) {
        return testRepository.findById(id);
    }

    public TestModel createTest(TestModel test) {
        return testRepository.save(test);
    }

    public TestModel updateTest(int id, TestModel test) {
        test.setId(id);
        return testRepository.save(test);
    }

    public boolean deleteTest(int id) {
        try {
            testRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
