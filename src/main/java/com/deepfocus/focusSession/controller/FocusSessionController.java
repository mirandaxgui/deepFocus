package com.deepfocus.focusSession.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepfocus.focusSession.FocusSession;
import com.deepfocus.focusSession.dto.FocusSessionDTO;
import com.deepfocus.focusSession.service.FocusSessionService;

@RestController
@RequestMapping("/focusSession")
public class FocusSessionController {

  @Autowired
  private FocusSessionService focusSessionService;
  
  @PostMapping("/create")
  public FocusSession create(@RequestBody FocusSessionDTO focusSessionDTO){
    var focusSession = focusSessionService.create(focusSessionDTO.getUserId(), focusSessionDTO.getDevice());
    return focusSession;
  }
}
