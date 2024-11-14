package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionsModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "test_id", nullable = false)
    private Integer testId;

    @Column(name = "question", columnDefinition = "TEXT", nullable = false)
    private String question;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
