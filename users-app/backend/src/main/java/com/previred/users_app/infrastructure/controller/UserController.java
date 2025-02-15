package com.previred.users_app.infrastructure.controller;

import com.previred.users_app.app.service.UserService;
import com.previred.users_app.domain.model.Password;
import com.previred.users_app.domain.model.User;
import com.previred.users_app.infrastructure.dto.CreateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UserResponseDto;
import com.previred.users_app.infrastructure.mapper.UserMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

@PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto requestDto) {
        User user = UserMapper.toDomain(requestDto);
        User createdUser = userService.create(user);
        return ResponseEntity.ok(UserMapper.toResponseDto(createdUser));
    }


    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") UUID id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") UUID id, @RequestBody User user) {
        user.setId(id);
        User updated = userService.update(user);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
