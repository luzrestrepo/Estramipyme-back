package com.project.controllers;

import com.project.models.TestModel;
import com.project.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public List<TestModel> getAllTests() {
        return testService.getAllTests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestModel> getTestById(@PathVariable int id) {
        return testService.getTestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TestModel createTest(@RequestBody TestModel test) {
        return testService.createTest(test);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestModel> updateTest(@PathVariable int id, @RequestBody TestModel test) {
        return ResponseEntity.ok(testService.updateTest(id, test));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable int id) {
        return testService.deleteTest(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
