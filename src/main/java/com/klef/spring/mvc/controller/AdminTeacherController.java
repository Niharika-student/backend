package com.klef.spring.mvc.controller;

import com.klef.spring.mvc.model.Teacher;
import com.klef.spring.mvc.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/teachers")
public class AdminTeacherController {

  private final TeacherService service;

  public AdminTeacherController(TeacherService service) {
    this.service = service;
  }

  @PostMapping
  public Teacher add(@RequestBody Teacher teacher) {
    return service.addTeacher(teacher);
  }

  @GetMapping
  public List<Teacher> all() {
    return service.getAllTeachers();
  }
}