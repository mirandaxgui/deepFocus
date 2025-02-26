package com.deepfocus.distraction.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepfocus.distraction.DistractionEvent;
import com.deepfocus.distraction.DistractionRepository;
import com.deepfocus.enums.DistractionType;
import com.deepfocus.focusSession.FocusSessionRepository;

@Service
public class DistractionService {
  @Autowired
  DistractionRepository distractionRepository;

  @Autowired
  FocusSessionRepository focusSessionRepository;

  public DistractionEvent registerDistraction(DistractionType distractionType, UUID focusId){
    var focusSession = focusSessionRepository.findByFocusId(focusId).get();
    var distraction = DistractionEvent.builder()
    .timestamp(LocalDateTime.now())
    .type(distractionType)
    .session(focusSession)
    .build();
    return distractionRepository.save(distraction);
  }

  public List<DistractionEvent> getDistractions(){
    //AUTENTICAR MAIS PRA FRENTE COM TOKEN
    return distractionRepository.findAll();
  }
}
