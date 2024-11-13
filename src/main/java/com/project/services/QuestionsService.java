package com.project.services;

import com.project.models.QuestionsModel;
import com.project.repositories.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    private QuestionsRepository preguntasRepository;

    // Obtiene todas las preguntas
    public List<QuestionsModel> getAllQuestions() {
        return preguntasRepository.findAll();
    }

    // Obtiene una pregunta por su ID
    public Optional<QuestionsModel> getQuestionById(int id) {
        return preguntasRepository.findById(id);
    }

    // Crea una nueva pregunta
    public QuestionsModel createQuestion(QuestionsModel question) {
        return preguntasRepository.save(question);
    }

    // Actualiza una pregunta existente
    public QuestionsModel updateQuestion(int id, QuestionsModel question) {
        question.setId(id);
        return preguntasRepository.save(question);
    }

    // Elimina una pregunta por su ID
    public boolean deleteQuestion(int id) {
        try {
            preguntasRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
