package com.deepfocus.distraction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepfocus.distraction.DistractionEvent;
import com.deepfocus.distraction.dto.DistractionDataDTO;
import com.deepfocus.distraction.service.DistractionService;


@RestController
@RequestMapping("/distractions")
public class DistractionController {
  @Autowired
  private DistractionService distractionService;
  @PostMapping("/")
  public DistractionEvent registerDistraction(@RequestBody DistractionDataDTO distractionData){
    return distractionService.registerDistraction(distractionData.getDistractionType(), distractionData.getFocusId());
  }

  @GetMapping()
  public List<DistractionEvent> getDistractions(){
    //AUTENTICAR MAIS PRA FRENTE
    return distractionService.getDistractions();
  }
  
}
