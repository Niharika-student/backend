package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Achievement;
import com.klef.spring.mvc.model.Student;
import com.klef.spring.mvc.repository.AchievementRepository;
import com.klef.spring.mvc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {

  private final AchievementRepository achievementRepo;
  private final StudentRepository studentRepo;

  public AchievementServiceImpl(AchievementRepository achievementRepo, StudentRepository studentRepo) {
    this.achievementRepo = achievementRepo;
    this.studentRepo = studentRepo;
  }

  @Override
  public Achievement addAchievementForStudent(String rollNumber, Achievement achievement) {
    Student student = studentRepo.findByRollNumber(rollNumber)
        .orElseThrow(() -> new RuntimeException("Student not found: " + rollNumber));
    achievement.setStudent(student);
    return achievementRepo.save(achievement);
  }

  @Override
  public List<Achievement> getAchievementsForStudent(String rollNumber) {
    return achievementRepo.findByStudent_RollNumber(rollNumber);
  }
}