package com.klef.spring.mvc.repository;

import com.klef.spring.mvc.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
  Optional<Admin> findByUsername(String username);
  boolean existsByUsername(String username);
}