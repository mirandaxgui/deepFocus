package com.deepfocus.user;

import java.time.LocalDateTime;
import java.util.UUID;

import com.deepfocus.enums.FocusMode;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String name;
  private String email;
  private String password;
  
  @Enumerated(EnumType.STRING)
  private FocusMode focusmode;

  private LocalDateTime createdAt;

}
