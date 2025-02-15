package com.previred.users_app.infrastructure.mapper;

import com.previred.users_app.domain.model.User;

import java.time.LocalDateTime;

import com.previred.users_app.domain.model.Password;
import com.previred.users_app.infrastructure.dto.CreateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UpdateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UserResponseDto;
public class UserMapper {

    public static User toDomain(CreateUserRequestDto dto) {
        return new User(
                null,
                null,
                null,
                dto.getRut(),
                dto.getDv(),
                dto.getNombres(),
                dto.getApellidos(),
                dto.getFechaNacimiento(),
                dto.getCorreoElectronico(),
                Password.fromPlainText(dto.getContrasena())
        );
    }

    public static UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getRut(),
                user.getDv(),
                user.getNombres(),
                user.getApellidos(),
                user.getFechaNacimiento(),
                user.getCorreoElectronico(),
                user.getCreadoEn(),
                user.getActualizadoEn());
    }
    
        public static User updateDomain(User existingUser, UpdateUserRequestDto dto) {
        return new User(
            existingUser.getId(),
            existingUser.getCreadoEn(),
            LocalDateTime.now(),
            existingUser.getRut(),
            existingUser.getDv(),
            dto.getNombres(),
            dto.getApellidos(),
            dto.getFechaNacimiento(),
            dto.getCorreoElectronico(),
            existingUser.getContrasena()
        );
    }
}
