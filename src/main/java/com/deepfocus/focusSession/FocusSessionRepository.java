package com.deepfocus.focusSession;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FocusSessionRepository extends JpaRepository<FocusSession, UUID> {
  Optional<FocusSession> findByFocusId(UUID focusId);
}
