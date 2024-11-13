package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.TeachersModel;
import com.project.repositories.TeachersRepository;

@Service
public class TeachersService {
    @Autowired
    private TeachersRepository teachersRepository;

    public List<TeachersModel> getAllTeachers() {
        return teachersRepository.findAll();
    }

    public Optional<TeachersModel> getTeacherById(int id) {
        return teachersRepository.findById(id);
    }

    public TeachersModel createTeacher(TeachersModel teacher) {
        return teachersRepository.save(teacher);
    }

    public TeachersModel updateTeacher(int id, TeachersModel teacher) {
        return teachersRepository.findById(id)
            .map(existingTeacher -> {
                existingTeacher.setName(teacher.getName());
                existingTeacher.setEmail(teacher.getEmail());
                existingTeacher.setPassword(teacher.getPassword());
                return teachersRepository.save(existingTeacher);
            })
            .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public void deleteTeacher(int id) {
        teachersRepository.deleteById(id);
    }
}
