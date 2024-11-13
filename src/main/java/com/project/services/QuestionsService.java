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
    private QuestionsRepository questionsRepository;

    public List<QuestionsModel> getAllQuestions() {
        return questionsRepository.findAll();
    }

    public Optional<QuestionsModel> getQuestionById(Integer id) {
        return questionsRepository.findById(id);
    }

    public QuestionsModel createQuestion(QuestionsModel question) {
        return questionsRepository.save(question);
    }

    public QuestionsModel updateQuestion(Integer id, QuestionsModel questionDetails) {
        return questionsRepository.findById(id).map(question -> {
            question.setTestId(questionDetails.getTestId());
            question.setQuestion(questionDetails.getQuestion());
            return questionsRepository.save(question);
        }).orElse(null);
    }

    public boolean deleteQuestion(Integer id) {
        return questionsRepository.findById(id).map(question -> {
            questionsRepository.delete(question);
            return true;
        }).orElse(false);
    }
}
