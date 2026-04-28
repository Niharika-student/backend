package com.klef.spring.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klef.spring.mvc.model.Course;
import com.klef.spring.mvc.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  // POST /api/courses
  @PostMapping
  public Course addCourse(@RequestBody Course course) {
    return courseService.addCourse(course);
  }

  // GET /api/courses
  @GetMapping
  public List<Course> getAllCourses() {
    return courseService.getAllCourses();
  }
}