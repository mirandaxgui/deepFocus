package com.deepfocus.focusSession.service;

import java.util.UUID;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.deepfocus.distraction.DistractionEvent;

@Service
public class FocusService {
  private final SimpMessagingTemplate messagingTemplate;

  private FocusService(SimpMessagingTemplate messagingTemplate){
    this.messagingTemplate = messagingTemplate;
  }

  public void notifyDistraction(UUID userId, DistractionEvent event){
    messagingTemplate.convertAndSend("/topic/focus/" + userId + event);
  }
}
