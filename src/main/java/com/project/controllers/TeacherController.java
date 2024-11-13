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

import com.project.models.TeacherModel;
import com.project.services.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<TeacherModel> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

     @GetMapping("/{id}")
    public ResponseEntity<TeacherModel> getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TeacherModel createTeacher(@RequestBody TeacherModel profesor) {
        return teacherService.createTeacher(profesor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherModel> updateTeacher(@PathVariable int id, @RequestBody TeacherModel profesor) {
        try {
            TeacherModel updatedTeacher = teacherService.updateTeacher(id, profesor);
            return ResponseEntity.ok(updatedTeacher);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
