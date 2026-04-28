package com.klef.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.spring.mvc.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}