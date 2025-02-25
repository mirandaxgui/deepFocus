package com.deepfocus.user.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepfocus.enums.FocusMode;
import com.deepfocus.user.UserEntity;
import com.deepfocus.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public UserEntity register(@RequestBody UserEntity userEntity){
    return userService.register(userEntity);
  }

  //CRIAR AUTENTICACAO
  @PostMapping("/login")
  public void login(){}

  @GetMapping("/")
  public void get(){}
  //AUTENTICACAO RECEBE TOKEN E RETORNA EMAIL, MODO DE FOCO ATUAL E ETC

  @PutMapping("/focus-mode")
  public UserEntity focusChange(FocusMode focusMode, UUID userId){
    return userService.updateFocusMode(userId, focusMode);
  }
}
