package com.previred.users_app.app.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.previred.users_app.domain.model.Password;
import com.previred.users_app.domain.model.User;
import com.previred.users_app.domain.repository.UserRepositoryPort;

@Service
public class UserService extends BaseCrudService<User, UUID> {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        super(userRepositoryPort);
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User create(User user) {
        if (user.getContrasena() != null && !user.getContrasena().getHashedValue().startsWith("$2a$")) {
            user.setContrasena(Password.fromPlainText(user.getContrasena().getHashedValue()));
        }
        user.setCreadoEn(LocalDateTime.now());
        user.setActualizadoEn(LocalDateTime.now());
        return super.create(user);
    }

    @Override
    public User update(User user) {
        user.setActualizadoEn(LocalDateTime.now());
        return super.update(user);
    }

}