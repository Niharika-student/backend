package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Course;
import com.klef.spring.mvc.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

  private final CourseRepository repo;

  public CourseServiceImpl(CourseRepository repo) {
    this.repo = repo;
  }

  @Override
  public Course addCourse(Course course) {
    if (repo.existsByCode(course.getCode())) {
      throw new RuntimeException("Course code already exists: " + course.getCode());
    }
    return repo.save(course);
  }

  @Override
  public List<Course> getAllCourses() {
    return repo.findAll();
  }
}