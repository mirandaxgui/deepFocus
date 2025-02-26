package com.deepfocus.focusSession.dto;

import java.util.UUID;


import lombok.Data;

@Data
public class FocusSessionDTO {
  private UUID userId;
  private String device;
}
