package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Student;

import java.util.List;

public interface StudentService {
  Student addStudent(Student student);
  List<Student> getAllStudents();
  Student getByRollNumber(String rollNumber);
}