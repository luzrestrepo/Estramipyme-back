package com.project.services;

import com.project.models.StudentsModel;
import com.project.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public List<StudentsModel> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Optional<StudentsModel> getStudentById(Long id) {
        return studentsRepository.findById(id);
    }

    public StudentsModel createStudent(StudentsModel student) {
        return studentsRepository.save(student);
    }

    public StudentsModel updateStudent(Long id, StudentsModel student) {
        student.setId(id);
        return studentsRepository.save(student);
    }

    public boolean deleteStudent(Long id) {
        try {
            studentsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
