package com.klef.spring.mvc.controller;

import com.klef.spring.mvc.model.Course;
import com.klef.spring.mvc.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {

  private final CourseRepository repo;

  public CourseController(CourseRepository repo) {
    this.repo = repo;
  }

  @PostMapping
  public Course create(@RequestBody Course c) {
    if (c.getName() == null || c.getName().isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name required");
    if (c.getCategory() == null || c.getCategory().isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "category required");
    if (c.getInstructor() == null || c.getInstructor().isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "instructor required");

    return repo.save(c);
  }

  @GetMapping
  public List<Course> list() {
    return repo.findAll();
  }
}