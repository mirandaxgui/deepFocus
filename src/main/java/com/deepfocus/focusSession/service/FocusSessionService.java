package com.deepfocus.focusSession.service;


import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepfocus.focusSession.FocusSession;
import com.deepfocus.focusSession.FocusSessionRepository;
import com.deepfocus.user.repository.UserRepository;

@Service
public class FocusSessionService {

  @Autowired
  private FocusSessionRepository focusSessionRepository;

  @Autowired
  private UserRepository userRepository;

  public FocusSession create(UUID userId, String device){
    var user = userRepository.findById(userId).get();
    var focusSession = FocusSession.builder()
    .user(user)
    .startTime(LocalDateTime.now())
    .endTime(LocalDateTime.now())
    .device(device)
    .build();

    return focusSessionRepository.save(focusSession);
  }
}
