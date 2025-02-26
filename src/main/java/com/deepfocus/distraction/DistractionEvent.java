package com.deepfocus.distraction;

import java.time.LocalDateTime;
import java.util.UUID;

import com.deepfocus.enums.DistractionType;
import com.deepfocus.focusSession.FocusSession;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "distraction_events")
public class DistractionEvent {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "session_id", nullable = false)
  private FocusSession session;

  private LocalDateTime timestamp;

  @Enumerated(EnumType.STRING)
  private DistractionType type;

  private String additionalInfo;
}
