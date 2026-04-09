package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Achievement;
import java.util.List;

public interface AchievementService
{
    Achievement addAchievementForStudent(String rollNumber, Achievement achievement);
    List<Achievement> getAchievementsForStudent(String rollNumber);
}