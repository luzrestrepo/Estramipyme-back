package com.project.services;

import com.project.models.AdminsModel;
import com.project.models.StudentsModel;
import com.project.models.TeachersModel;
import com.project.repositories.AdminsRepository;
import com.project.repositories.StudentsRepository;
import com.project.repositories.TeachersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Servicio para estudiantes
@SuppressWarnings("unused")
@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public StudentsModel createStudent(StudentsModel student) {
        return studentsRepository.save(student);
    }

    public StudentsModel updateStudent(Long id, StudentsModel student) {
        return studentsRepository.findById(id).map(existingStudent -> {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPassword(student.getPassword());
            return studentsRepository.save(existingStudent);
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Optional<StudentsModel> findByEmail(String email) {
        return studentsRepository.findByEmail(email);
    }

    public boolean deleteStudent(Long id) {
        return studentsRepository.findById(id).map(student -> {
            studentsRepository.delete(student);
            return true;
        }).orElse(false);
    }

    public Optional<StudentsModel> getStudentById(Long id) {
        return studentsRepository.findById(id);
    }

    public List<StudentsModel> getAllStudents() {
        return studentsRepository.findAll();
    }

    public StudentsModel deleteStudent(StudentsModel student) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }
}

