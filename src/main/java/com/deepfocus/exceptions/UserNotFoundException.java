package com.deepfocus.exceptions;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(){
    super("Este usuário não existe");
  }
}
