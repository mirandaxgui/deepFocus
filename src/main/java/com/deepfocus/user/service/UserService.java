package com.deepfocus.user.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepfocus.enums.FocusMode;
import com.deepfocus.exceptions.UserNotFoundException;
import com.deepfocus.user.UserEntity;
import com.deepfocus.user.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public UserEntity register(UserEntity userEntity){
    var user = UserEntity.builder()
    .email(userEntity.getEmail())
    .name(userEntity.getName())
    .password(userEntity.getPassword())
    .focusmode(FocusMode.RELAX)
    .createdAt(LocalDateTime.now())
    .build();
    
    return userRepository.save(user);

  }

  public Optional<UserEntity> findUser(UUID id){
    return userRepository.findById(id);
  }

  public UserEntity updateFocusMode(UUID id, FocusMode focusMode){
    var user = userRepository.findById(id);

    if (user.isPresent()){
      var userExists = user.get();
      userExists.setFocusmode(focusMode);
      return userExists;
    } else {
      throw new UserNotFoundException();
    }
  }
  //CONSTRUIR AUTENTICACAO
  public void login(){}
}
