package com.klef.spring.mvc.controller;

import com.klef.spring.mvc.model.Role;
import com.klef.spring.mvc.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  public static class LoginRequest {
    public String username;
    public String password;
  }

  public static class LoginResponse {
    public String message;
    public LoginResponse(String message) { this.message = message; }
  }

  @PostMapping("/student/login")
  public LoginResponse studentLogin(@RequestBody LoginRequest req) {
    String result = authService.login(Role.STUDENT, req.username, req.password);
    return new LoginResponse(result);
  }

  @PostMapping("/admin/login")
  public LoginResponse adminLogin(@RequestBody LoginRequest req) {
    String result = authService.login(Role.ADMIN, req.username, req.password);
    return new LoginResponse(result);
  }
}