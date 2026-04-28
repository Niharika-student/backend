package com.klef.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.spring.mvc.model.Achievement;
import com.klef.spring.mvc.repository.AchievementRepository;
import com.klef.spring.mvc.repository.StudentRepository;

@Service
public class AchievementServiceImpl implements AchievementService {

  private final AchievementRepository achievementRepo;
  private final StudentRepository studentRepo;

  public AchievementServiceImpl(AchievementRepository achievementRepo,
                                StudentRepository studentRepo) {
    this.achievementRepo = achievementRepo;
    this.studentRepo = studentRepo;
  }

  @Override
  public Achievement addAchievementForStudent(String studentId, Achievement achievement) {

    if (!studentRepo.existsByRollNumber(studentId)) {
      throw new RuntimeException("Student not found with roll number: " + studentId);
    }

    achievement.setStudentId(studentId);

    return achievementRepo.save(achievement);
  }

  @Override
  public List<Achievement> getAllAchievements() {
    return achievementRepo.findAll();
  }

  @Override
  public List<Achievement> getAchievementsForStudent(String studentId) {
    return achievementRepo.findByStudentId(studentId);
  }

  @Override
  public void deleteAchievement(Long id) {
    achievementRepo.deleteById(id);
  }
}