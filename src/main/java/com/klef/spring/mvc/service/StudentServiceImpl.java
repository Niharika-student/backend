package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Student;
import com.klef.spring.mvc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository repo;

  public StudentServiceImpl(StudentRepository repo) {
    this.repo = repo;
  }

  @Override
  public Student addStudent(Student student) {
    if (repo.existsByRollNumber(student.getRollNumber())) {
      throw new RuntimeException("Roll number already exists: " + student.getRollNumber());
    }
    return repo.save(student);
  }

  @Override
  public List<Student> getAllStudents() {
    return repo.findAll();
  }

  @Override
  public Student getByRollNumber(String rollNumber) {
    return repo.findByRollNumber(rollNumber)
        .orElseThrow(() -> new RuntimeException("Student not found: " + rollNumber));
  }
}