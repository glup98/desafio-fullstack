package com.previred.users_app.infrastructure.controller;

import com.previred.users_app.app.service.UserService;
import com.previred.users_app.domain.model.User;
import com.previred.users_app.infrastructure.dto.CreateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UserResponseDto;
import com.previred.users_app.infrastructure.exception.ResourceNotFoundException;
import com.previred.users_app.infrastructure.exception.BadRequestException;
import com.previred.users_app.infrastructure.mapper.UserMapper;

import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody(required = true) CreateUserRequestDto requestDto) {
        User user = UserMapper.toDomain(requestDto);
        User createdUser = userService.create(user);
        return ResponseEntity.ok(UserMapper.toResponseDto(createdUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable("id") String id) {
        UUID uuid = validateAndParseUUID(id);
        User user = userService.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));

        return ResponseEntity.ok(UserMapper.toResponseDto(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> users = userService.findAll()
                .stream()
                .map(UserMapper::toResponseDto)
                .toList();
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable("id") String id,
            @Valid @RequestBody User user) {

        UUID uuid = validateAndParseUUID(id);
        
        if (userService.findById(uuid).isEmpty()) {
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }

        user.setId(uuid);
        User updated = userService.update(user);
        return ResponseEntity.ok(UserMapper.toResponseDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        UUID uuid = validateAndParseUUID(id);

        if (userService.findById(uuid).isEmpty()) {
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }

        userService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
    
    private UUID validateAndParseUUID(String id) {
        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("El ID proporcionado no es un UUID válido: " + id);
        }
    }
}
