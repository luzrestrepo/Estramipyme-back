package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "respuestas")
public class AnswersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pregunta_id")
    private int preguntaId;

    @SuppressWarnings("unused")
    private String respuesta;

    @Column(name = "empresa_id")
    private int empresaId;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", insertable = false, updatable = false)
    private QuestionsModel pregunta;

    public void setId(int id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    // Getters y Setters
}
