package com.example.security.repository;

import com.example.security.model.Livestock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivestockRepository extends JpaRepository<Livestock, Long> {

    Livestock getByCattleName(String cattleName);
}
