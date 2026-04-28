package com.klef.spring.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.spring.mvc.model.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

  // ✅ because Achievement has field studentId
  List<Achievement> findByStudentId(String studentId);
}