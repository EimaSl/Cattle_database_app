package com.example.security.repository;

import com.example.security.model.Meat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatRepository extends JpaRepository<Meat, Long> {
}
