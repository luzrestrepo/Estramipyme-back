package com.project.controllers;

import com.project.models.StudentsModel;
import com.project.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public List<StudentsModel> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentsModel> getStudentById(@PathVariable Long id) {
        return studentsService.getStudentById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StudentsModel createStudent(@RequestBody StudentsModel student) {
        return studentsService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentsModel> updateStudent(@PathVariable Long id, @RequestBody StudentsModel student) {
        StudentsModel updatedStudent = studentsService.updateStudent(id, student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentsService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
