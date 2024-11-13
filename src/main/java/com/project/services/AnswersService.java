package com.project.services;

import com.project.models.AnswersModel;
import com.project.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswersService {

    @Autowired
    private AnswersRepository answersRepository;

    // Obtener todas las respuestas
    public List<AnswersModel> getAllAnswers() {
        return answersRepository.findAll();
    }

    // Obtener una respuesta por su ID
    public Optional<AnswersModel> getAnswerById(int id) {
        return answersRepository.findById(id);
    }

    // Crear una nueva respuesta
    public AnswersModel createAnswer(AnswersModel answer) {
        return answersRepository.save(answer);
    }

    // Actualizar una respuesta existente
    public Optional<AnswersModel> updateAnswer(int id, AnswersModel answer) {
        return answersRepository.findById(id)
                .map(existingAnswer -> {
                    answer.setId(id); // Establecer el ID de la respuesta existente
                    return answersRepository.save(answer); // Guardar y devolver la respuesta actualizada
                });
    }

    // Eliminar una respuesta por su ID
    public boolean deleteAnswer(int id) {
        if (answersRepository.existsById(id)) {
            answersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
