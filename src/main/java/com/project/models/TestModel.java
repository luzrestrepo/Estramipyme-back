package com.project.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "test")
public class TestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "empresas_id")
    private int empresasId;

    @SuppressWarnings("unused")
    private Date fecha;
    @SuppressWarnings("unused")
    private Timestamp fecha_respuesta;
    @SuppressWarnings("unused")
    private Timestamp fecha_siguiente_respuesta;

    @Column(name = "empresa_id")
    private Long empresaId;

    @SuppressWarnings("unused")
    private String pregunta1;
    @SuppressWarnings("unused")
    private String pregunta2;
    @SuppressWarnings("unused")
    private String pregunta3;
    @SuppressWarnings("unused")
    private String pregunta4;
    @SuppressWarnings("unused")
    private String pregunta5;
    @SuppressWarnings("unused")
    private String pregunta6;
    @SuppressWarnings("unused")
    private String pregunta7;
    @SuppressWarnings("unused")
    private String pregunta8;
    @SuppressWarnings("unused")
    private String pregunta9;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuestionsModel> preguntas;

    public void setId(int id2) {
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    // Getters y Setters
}
