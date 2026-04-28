package com.klef.spring.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klef.spring.mvc.model.Achievement;
import com.klef.spring.mvc.service.AchievementService;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = "*")
public class AchievementController {

  private final AchievementService achievementService;

  public AchievementController(AchievementService achievementService) {
    this.achievementService = achievementService;
  }

  // POST /api/achievements/student/STU001
  @PostMapping("/student/{studentId}")
  public Achievement addAchievement(@PathVariable String studentId,
                                    @RequestBody Achievement achievement) {
    return achievementService.addAchievementForStudent(studentId, achievement);
  }

  // GET /api/achievements
  @GetMapping
  public List<Achievement> getAllAchievements() {
    return achievementService.getAllAchievements();
  }

  // GET /api/achievements/student/STU001
  @GetMapping("/student/{studentId}")
  public List<Achievement> getAchievementsByStudent(@PathVariable String studentId) {
    return achievementService.getAchievementsForStudent(studentId);
  }

  // DELETE /api/achievements/5
  @DeleteMapping("/{id}")
  public void deleteAchievement(@PathVariable Long id) {
    achievementService.deleteAchievement(id);
  }
}