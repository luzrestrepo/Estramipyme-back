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
    private StudentsRepository studentRepository;

    public List<StudentsModel> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentsModel> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public StudentsModel createStudent(StudentsModel student) {
        return studentRepository.save(student);
    }

    public StudentsModel updateStudent(Long id, StudentsModel studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setCompanyId(studentDetails.getCompanyId());
            student.setTeacherId(studentDetails.getTeacherId());
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setPassword(studentDetails.getPassword());
            student.setAddress(studentDetails.getAddress());
            student.setPhone(studentDetails.getPhone());
            return studentRepository.save(student);
        }).orElse(null);
    }

    public boolean deleteStudent(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return true;
        }).orElse(false);
    }
}
