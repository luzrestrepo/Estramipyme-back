package com.project.controllers;

import com.project.models.AnswersModel;
import com.project.services.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswersController {

    @Autowired
    private AnswersService answersService;

    // Obtener todas las respuestas
    @GetMapping
    public List<AnswersModel> getAllAnswers() {
        return answersService.getAllAnswers();
    }

    // Obtener una respuesta por ID
    @GetMapping("/{id}")
    public ResponseEntity<AnswersModel> getAnswerById(@PathVariable int id) {
        return answersService.getAnswerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva respuesta
    @PostMapping
    public AnswersModel createAnswer(@RequestBody AnswersModel answer) {
        return answersService.createAnswer(answer);
    }

    // Actualizar una respuesta existente
    @PutMapping("/{id}")
    public ResponseEntity<AnswersModel> updateAnswer(@PathVariable int id, @RequestBody AnswersModel answer) {
        return answersService.updateAnswer(id, answer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una respuesta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable int id) {
        return answersService.deleteAnswer(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
