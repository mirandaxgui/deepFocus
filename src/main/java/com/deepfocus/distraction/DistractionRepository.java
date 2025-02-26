package com.deepfocus.distraction;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistractionRepository extends JpaRepository<DistractionEvent, UUID> {
  
}
