package com.project.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "graphs")
public class GraphsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "test_id")
    private Integer testId;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "data", columnDefinition = "json")
    private String data; // Storing the JSON data as a String

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
