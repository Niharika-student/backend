package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Teacher;

import java.util.List;

public interface TeacherService {
  Teacher addTeacher(Teacher teacher);
  List<Teacher> getAllTeachers();
}