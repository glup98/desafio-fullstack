package com.previred.users_app.app.service;

import org.springframework.stereotype.Service;

import com.previred.users_app.domain.model.User;
import com.previred.users_app.domain.repository.UserRepositoryPort;

@Service
public class UserService extends BaseCrudService<User, Long> {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        super(userRepositoryPort);
        this.userRepositoryPort = userRepositoryPort;
    }
}