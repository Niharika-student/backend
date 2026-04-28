package com.klef.spring.mvc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;        // Course name

  @Column(nullable = false)
  private String category;    // Academic / etc (from dropdown)

  @Column(nullable = false)
  private String instructor;  // Instructor name

  // getters & setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public String getInstructor() { return instructor; }
  public void setInstructor(String instructor) { this.instructor = instructor; }
}