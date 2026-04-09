package com.klef.spring.mvc.repository;

import com.klef.spring.mvc.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long>
{
    List<Achievement> findByStudent_RollNumber(String rollNumber);
}