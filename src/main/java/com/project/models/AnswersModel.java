package com.project.models;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class AnswersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id", nullable = false)
    private Integer questionId;

    @Column(name = "answer", columnDefinition = "TEXT", nullable = false)
    private String answer;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
