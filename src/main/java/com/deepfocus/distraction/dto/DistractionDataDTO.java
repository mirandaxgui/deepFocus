package com.deepfocus.distraction.dto;

import java.util.UUID;

import com.deepfocus.enums.DistractionType;

import lombok.Data;

@Data
public class DistractionDataDTO {
  DistractionType distractionType;
  UUID focusId;
}
