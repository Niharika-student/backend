package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Admin;
import com.klef.spring.mvc.model.Role;
import com.klef.spring.mvc.model.Student;
import com.klef.spring.mvc.repository.AdminRepository;
import com.klef.spring.mvc.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthServiceImpl implements AuthService {

  private final StudentRepository studentRepo;
  private final AdminRepository adminRepo;

  public AuthServiceImpl(StudentRepository studentRepo, AdminRepository adminRepo) {
    this.studentRepo = studentRepo;
    this.adminRepo = adminRepo;
  }

  @Override
  public String login(Role role, String usernameOrRoll, String password) {

    if (role == null)
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "role is required");

    if (usernameOrRoll == null || usernameOrRoll.isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username required");

    if (password == null || password.isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password required");

    switch (role) {

      case ADMIN -> {
        Admin a = adminRepo.findByUsername(usernameOrRoll)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid admin username"));

        if (!a.getPassword().equals(password))
          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");

        return "ADMIN_LOGIN_SUCCESS";
      }

      case STUDENT -> {
        Student s = studentRepo.findByRollNumber(usernameOrRoll)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid roll number"));

        if (!s.getPassword().equals(password))
          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");

        return "STUDENT_LOGIN_SUCCESS";
      }

      default -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid role");
    }
  }
}