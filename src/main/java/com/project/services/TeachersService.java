package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.TeacherModel;
import com.project.repositories.TeacherRepository;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherModel> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<TeacherModel> getTeacherById(int id) {
        return teacherRepository.findById(id);
    }

    public TeacherModel createTeacher(TeacherModel profesor) {
        return teacherRepository.save(profesor);
    }

    public TeacherModel updateTeacher(int id, TeacherModel profesor) {
        return teacherRepository.findById(id)
            .map(existingProfesor -> {
                existingProfesor.setName(profesor.getName());
                existingProfesor.setEmail(profesor.getEmail());
                existingProfesor.setPassword(profesor.getPassword());
                return teacherRepository.save(existingProfesor);
            })
            .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
