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
    return repo.save(course);
  }

  @Override
  public List<Course> getAllCourses() {
    return repo.findAll();
  }
}