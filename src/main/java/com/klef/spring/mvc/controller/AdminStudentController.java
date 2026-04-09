package com.klef.spring.mvc.controller;

import com.klef.spring.mvc.model.Student;
import com.klef.spring.mvc.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/students")
public class AdminStudentController {

  private final StudentService service;

  public AdminStudentController(StudentService service) {
    this.service = service;
  }

  @PostMapping
  public Student add(@RequestBody Student student) {
    return service.addStudent(student);
  }

  @GetMapping
  public List<Student> all() {
    return service.getAllStudents();
  }
}