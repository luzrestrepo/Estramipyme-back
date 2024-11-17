package com.project.controllers;

import com.project.models.StudentsModel;
import com.project.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    // Obtener todos los estudiantes
    @GetMapping
    public List<StudentsModel> getAllStudents() {
        return studentsService.getAllStudents();
    }

    // Obtener estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentsModel> getStudentById(@PathVariable Long id) {
        return studentsService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear estudiante
    @PostMapping
    public StudentsModel createStudent(@Validated @RequestBody StudentsModel student) {
        return studentsService.createStudent(student);
    }

    // Actualizar estudiante
    @PutMapping("/{id}")
    public ResponseEntity<StudentsModel> updateStudent(@PathVariable Long id, @Validated @RequestBody StudentsModel student) {
        StudentsModel updatedStudent = studentsService.updateStudent(id, student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }

    // Eliminar estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentsService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Buscar estudiante por email
    @GetMapping("/email/{email}")
    public ResponseEntity<StudentsModel> getStudentByEmail(@PathVariable String email) {
        return studentsService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
