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

    // Obtener todos los profesores
    public List<TeachersModel> getAllTeachers() {
        return teachersRepository.findAll();
    }

    // Obtener un profesor por su ID
    public Optional<TeachersModel> getTeacherById(int id) {
        return teachersRepository.findById(id);
    }

    // Crear un nuevo profesor
    public TeachersModel createTeacher(TeachersModel teacher) {
        return teachersRepository.save(teacher);
    }

    // Actualizar un profesor existente
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

    // Eliminar un profesor
    public void deleteTeacher(int id) {
        teachersRepository.deleteById(id);
    }

    // Buscar profesor por correo electrónico
    public Optional<TeachersModel> findByEmail(String email) {
        return teachersRepository.findByEmail(email); // Llamada al repositorio para buscar por email
    }
}
