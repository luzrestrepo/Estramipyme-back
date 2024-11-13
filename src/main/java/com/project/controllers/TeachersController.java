package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.TeachersModel;
import com.project.services.TeachersService;

@RestController
@RequestMapping("/teachers")
public class TeachersController {
    @Autowired
    private TeachersService teachersService;

    @GetMapping
    public List<TeachersModel> getAllTeachers(){
        return teachersService.getAllTeachers();
    }

     @GetMapping("/{id}")
    public ResponseEntity<TeachersModel> getTeacherById(@PathVariable int id) {
        return teachersService.getTeacherById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TeachersModel createTeacher(@RequestBody TeachersModel profesor) {
        return teachersService.createTeacher(profesor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachersModel> updateTeacher(@PathVariable int id, @RequestBody TeachersModel profesor) {
        try {
            TeachersModel updatedTeacher = teachersService.updateTeacher(id, profesor);
            return ResponseEntity.ok(updatedTeacher);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        teachersService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
