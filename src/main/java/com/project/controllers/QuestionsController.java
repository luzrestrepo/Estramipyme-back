package com.project.controllers;

import com.project.models.QuestionsModel;
import com.project.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping
    public List<QuestionsModel> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionsModel> getQuestionById(@PathVariable Integer id) {
        Optional<QuestionsModel> question = questionsService.getQuestionById(id);
        return question.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public QuestionsModel createQuestion(@RequestBody QuestionsModel question) {
        return questionsService.createQuestion(question);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionsModel> updateQuestion(@PathVariable Integer id, @RequestBody QuestionsModel questionDetails) {
        QuestionsModel updatedQuestion = questionsService.updateQuestion(id, questionDetails);
        return updatedQuestion != null ? ResponseEntity.ok(updatedQuestion) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) {
        boolean deleted = questionsService.deleteQuestion(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
