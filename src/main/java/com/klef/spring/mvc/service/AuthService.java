package com.klef.spring.mvc.service;

import com.klef.spring.mvc.model.Role;

public interface AuthService {
  String login(Role role, String usernameOrRoll, String password);
}