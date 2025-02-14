package com.ejemplo.desafio.domain.repository;

import java.util.List;
import java.util.Optional;

import com.ejemplo.desafio.domain.model.User;

public interface UserRepositoryPort {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long rut);

    User updateUser(User user);

    void deleteUserById(Long rut);
}
