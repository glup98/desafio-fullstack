package com.previred.users_app.infrastructure.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.previred.users_app.infrastructure.persistence.entity.UserEntity;


public interface UserRepositorySpringData extends JpaRepository<UserEntity, UUID> {
}
