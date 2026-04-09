package com.klef.spring.mvc.controller;

import com.klef.spring.mvc.model.Admin;
import com.klef.spring.mvc.repository.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

  private final AdminRepository adminRepo;

  public AdminController(AdminRepository adminRepo) {
    this.adminRepo = adminRepo;
  }

  @PostMapping("/register")
  public Admin register(@RequestBody Admin admin) {

    if (admin.getUsername() == null || admin.getUsername().isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username required");

    if (admin.getPassword() == null || admin.getPassword().isBlank())
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password required");

    if (adminRepo.existsByUsername(admin.getUsername()))
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Admin username already exists");

    return adminRepo.save(admin);
  }
}