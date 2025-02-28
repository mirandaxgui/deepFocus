package com.deepfocus.user.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepfocus.user.dto.AuthUserDTO;
import com.deepfocus.user.service.AuthUserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class AuthUserController {
  @Autowired
  private AuthUserService authUserService;

  @PostMapping("/auth")
  public ResponseEntity<Object> authUser(@RequestBody AuthUserDTO authUserDTO, HttpServletResponse response){
    try {
      var jwtToken = authUserService.execute(authUserDTO);

      Cookie jwtCookie = new Cookie("token", jwtToken);
      jwtCookie.setHttpOnly(false);
      jwtCookie.setSecure(false);
      jwtCookie.setPath("/");
      jwtCookie.setMaxAge(60 * 60 * 8);
      response.addHeader("Set-Cookie", "token=" + jwtToken + "; Path=/; HttpOnly; Secure; Max-Age=28800; SameSite=None");
    
      return ResponseEntity.ok().body("Autenticação realizada com sucesso!");
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }
}
