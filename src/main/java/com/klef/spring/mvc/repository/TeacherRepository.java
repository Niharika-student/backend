package com.klef.spring.mvc.repository;

import com.klef.spring.mvc.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
  boolean existsByEmail(String email);
}