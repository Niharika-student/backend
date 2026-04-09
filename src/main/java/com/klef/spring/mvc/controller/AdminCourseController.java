package com.klef.spring.mvc.controller;

import com.klef.spring.mvc.model.Course;
import com.klef.spring.mvc.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/courses")
public class AdminCourseController {

  private final CourseService service;

  public AdminCourseController(CourseService service) {
    this.service = service;
  }

  @PostMapping
  public Course add(@RequestBody Course course) {
    return service.addCourse(course);
  }

  @GetMapping
  public List<Course> all() {
    return service.getAllCourses();
  }
}