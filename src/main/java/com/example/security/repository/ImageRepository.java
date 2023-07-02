package com.example.security.repository;

import com.example.security.model.Image;
import com.example.security.model.Livestock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
