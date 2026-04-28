package com.klef.spring.mvc.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "achievements")
public class Achievement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String studentId;   // e.g., STU001 (from your UI)

  @Column(nullable = false)
  private String title;       // e.g., "First Place - State Science Fair"

  @Column(length = 1000)
  private String description;

  @Column(nullable = false)
  private String category;    // e.g., Academic Competition, Arts, Sports

  @Column(nullable = false)
  private String level;       // e.g., School, State, National

  private LocalDate date;     // e.g., 2025-11-15
  @Column(name = "position_award", nullable = false)
  private String position;    // e.g., Winner / 1st Place

  // getters & setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getStudentId() { return studentId; }
  public void setStudentId(String studentId) { this.studentId = studentId; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public String getLevel() { return level; }
  public void setLevel(String level) { this.level = level; }

  public LocalDate getDate() { return date; }
  public void setDate(LocalDate date) { this.date = date; }

  public String getPosition() { return position; }
  public void setPosition(String position) { this.position = position; }
}