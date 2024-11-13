package com.project.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "activities")
public class ActivitiesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column
    private String type;

    @Column
    private Date date;

    @Column
    private String user;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCompanyId() { return companyId; }
    public void setCompanyId(Integer companyId) { this.companyId = companyId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
}
