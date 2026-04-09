package com.klef.spring.mvc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "achievements")
public class Achievement
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String positionAward;

    @Column(nullable = false)
    private String rollNumber;

    // Many achievements belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Achievement() {}

    public Achievement(String title, String description, String date,
                       String positionAward, String rollNumber)
    {
        this.title = title;
        this.description = description;
        this.date = date;
        this.positionAward = positionAward;
        this.rollNumber = rollNumber;
    }

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getPositionAward() {
        return positionAward;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public Student getStudent() {
        return student;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPositionAward(String positionAward) {
        this.positionAward = positionAward;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}