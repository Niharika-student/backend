package com.klef.spring.mvc.controller;

import com.klef.spring.mvc.model.Student;
import com.klef.spring.mvc.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

  private final StudentRepository studentRepo;

  public StudentController(StudentRepository studentRepo) {
    this.studentRepo = studentRepo;
  }

  // REGISTER STUDENT
  @PostMapping("/register")
  public Student register(@RequestBody Student s) {

    if (s.getRollNumber() == null || s.getRollNumber().isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "rollNumber required");

    if (s.getPassword() == null || s.getPassword().isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password required");

    if (studentRepo.existsByRollNumber(s.getRollNumber()))
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Roll number already exists");

    return studentRepo.save(s);
  }
}