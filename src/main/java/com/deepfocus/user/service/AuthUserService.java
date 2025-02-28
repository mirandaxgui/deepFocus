package com.deepfocus.user.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.method.P;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.deepfocus.user.dto.AuthUserDTO;
import com.deepfocus.user.repository.UserRepository;



@Service
public class AuthUserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Value("${security.token.secret.user}")
  private String secretKey;

  public String execute(AuthUserDTO authUserDTO) throws AuthenticationException{
    var user = this.userRepository.findByEmail(authUserDTO.getEmail().toLowerCase()).orElseThrow(() -> {
      throw new UsernameNotFoundException("Email/password incorrect");
    });

    var passwordMatches = this.passwordEncoder.matches(authUserDTO.getPassword(), user.getPassword());
    
    if (!passwordMatches){
      throw new AuthenticationException();
    }

    this.userRepository.save(user);

    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    var expiresIn = Instant.now().plus(Duration.ofHours(8));
    var token = JWT.create().withIssuer("deepFocus")
    .withExpiresAt(expiresIn)
    .withSubject(user.getId().toString())
    .withClaim("roles", Arrays.asList("USER"))
    .sign(algorithm);

    return token;
  }
}
