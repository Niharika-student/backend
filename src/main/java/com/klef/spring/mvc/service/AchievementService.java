package com.klef.spring.mvc.service;

import java.util.List;
import com.klef.spring.mvc.model.Achievement;

public interface AchievementService {

  Achievement addAchievementForStudent(String studentId, Achievement achievement);

  List<Achievement> getAllAchievements();

  List<Achievement> getAchievementsForStudent(String studentId);

  void deleteAchievement(Long id);
}