package com.project.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "preguntas")
public class QuestionsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "test_id")
    private int testId;

    @SuppressWarnings("unused")
    private String pregunta;

    @Column(name = "empresa_id")
    private int empresaId;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "opciones_seleccion")
    private String opcionesSeleccion;

    @SuppressWarnings("unused")
    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "test_id", insertable = false, updatable = false)
    private TestModel test;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswersModel> respuestas;

    public enum Tipo {
        ABIERTA,
        SELECCION
    }

    public void setId(int id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    // Getters y Setters
}

