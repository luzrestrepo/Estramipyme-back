package com.project.controllers;

import com.project.models.AnswersModel;
import com.project.services.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/answers")
public class AnswersController {

    @Autowired
    private AnswersService answersService;

    @GetMapping
    public List<AnswersModel> getAllAnswers() {
        return answersService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswersModel> getAnswerById(@PathVariable Integer id) {
        Optional<AnswersModel> answer = answersService.getAnswerById(id);
        return answer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AnswersModel createAnswer(@RequestBody AnswersModel answer) {
        return answersService.createAnswer(answer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswersModel> updateAnswer(@PathVariable Integer id, @RequestBody AnswersModel answerDetails) {
        AnswersModel updatedAnswer = answersService.updateAnswer(id, answerDetails);
        return updatedAnswer != null ? ResponseEntity.ok(updatedAnswer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Integer id) {
        boolean deleted = answersService.deleteAnswer(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
