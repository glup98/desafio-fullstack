package com.previred.users_app.infrastructure.mapper;

import com.previred.users_app.domain.model.User;
import com.previred.users_app.domain.model.Password;
import com.previred.users_app.infrastructure.dto.CreateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UserResponseDto;

// import java.time.LocalDate;

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
}
