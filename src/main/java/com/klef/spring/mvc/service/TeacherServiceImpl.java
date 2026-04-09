package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Teacher;
import com.klef.spring.mvc.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

  private final TeacherRepository repo;

  public TeacherServiceImpl(TeacherRepository repo) {
    this.repo = repo;
  }

  @Override
  public Teacher addTeacher(Teacher teacher) {
    if (repo.existsByEmail(teacher.getEmail())) {
      throw new RuntimeException("Teacher email already exists: " + teacher.getEmail());
    }
    return repo.save(teacher);
  }

  @Override
  public List<Teacher> getAllTeachers() {
    return repo.findAll();
  }
}