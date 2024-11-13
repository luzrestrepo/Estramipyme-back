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

    public List<AnswersModel> getAllAnswers() {
        return answersRepository.findAll();
    }

    public Optional<AnswersModel> getAnswerById(Integer id) {
        return answersRepository.findById(id);
    }

    public AnswersModel createAnswer(AnswersModel answer) {
        return answersRepository.save(answer);
    }

    public AnswersModel updateAnswer(Integer id, AnswersModel answerDetails) {
        return answersRepository.findById(id).map(answer -> {
            answer.setQuestionId(answerDetails.getQuestionId());
            answer.setAnswer(answerDetails.getAnswer());
            return answersRepository.save(answer);
        }).orElse(null);
    }

    public boolean deleteAnswer(Integer id) {
        return answersRepository.findById(id).map(answer -> {
            answersRepository.delete(answer);
            return true;
        }).orElse(false);
    }
}
