package com.deepfocus.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepfocus.user.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID>{
  Optional<UserEntity> findById(UUID id);
}
