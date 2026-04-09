package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Course;

import java.util.List;

public interface CourseService {
  Course addCourse(Course course);
  List<Course> getAllCourses();
}