package com.deepfocus.entity;

import java.util.UUID;

import com.deepfocus.user.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity(name = "focus_settings")
public class FocusSettings {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  private boolean blockNotifications; // Bloquear notificações
  private boolean autoSuggestBreaks; // Sugere pausas automáticas
  private boolean enableAIAnalysis; // Ativa IA para analisar foco

}


