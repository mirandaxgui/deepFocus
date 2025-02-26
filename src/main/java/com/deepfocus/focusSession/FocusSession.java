package com.deepfocus.focusSession;

import java.time.LocalDateTime;
import java.util.UUID;

import com.deepfocus.user.UserEntity;

import jakarta.persistence.Entity;
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
@Entity(name = "focus_sessions")
public class FocusSession {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID focusId;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  private LocalDateTime startTime;
  private LocalDateTime endTime;
  private int distractionCount;
  
  private double focusScore;

  private String device;

}
