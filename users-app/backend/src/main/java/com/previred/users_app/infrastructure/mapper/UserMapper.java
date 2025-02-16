package com.previred.users_app.infrastructure.mapper;

import com.previred.users_app.domain.model.User;

import com.previred.users_app.domain.model.Password;
import com.previred.users_app.infrastructure.dto.CreateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UpdateUserRequestDto;
import com.previred.users_app.infrastructure.dto.UserResponseDto;

public class UserMapper {

    public static User toDomain(CreateUserRequestDto dto) {
        String[] rutParts = dto.getRut().split("-");
        Long rutNumber = Long.parseLong(rutParts[0]);
        String dv = rutParts[1].toUpperCase();

        return new User(
                null,
                null,
                null,
                rutNumber,
                dv,
                dto.getNombres(),
                dto.getApellidos(),
                dto.getFechaNacimiento(),
                dto.getCorreoElectronico(),
                Password.fromPlainText(dto.getContrasena()));
    }

    public static UserResponseDto toResponseDto(User user) {
        String formattedRut = user.getRut() + "-" + user.getDv();
        return new UserResponseDto(
                user.getId(),
                formattedRut,
                user.getNombres(),
                user.getApellidos(),
                user.getFechaNacimiento(),
                user.getCorreoElectronico(),
                user.getCreadoEn(),
                user.getActualizadoEn());
    }

    public static User updateDomain(User existingUser, UpdateUserRequestDto requestDto) {
        if (requestDto.getNombres() != null && !requestDto.getNombres().isBlank()) {
            existingUser.setNombres(requestDto.getNombres());
        }

        if (requestDto.getApellidos() != null && !requestDto.getApellidos().isBlank()) {
            existingUser.setApellidos(requestDto.getApellidos());
        }

        if (requestDto.getFechaNacimiento() != null) {
            existingUser.setFechaNacimiento(requestDto.getFechaNacimiento());
        }

        if (requestDto.getCorreoElectronico() != null && !requestDto.getCorreoElectronico().isBlank()) {
            existingUser.setCorreoElectronico(requestDto.getCorreoElectronico());
        }

        if (requestDto.getRut() != null && !requestDto.getRut().isBlank()) {
            String[] rutParts = requestDto.getRut().split("-");
            if (rutParts.length == 2) {
                try {
                    Long rutNumber = Long.parseLong(rutParts[0]);
                    String dv = rutParts[1].toUpperCase();
                    existingUser.setRut(rutNumber);
                    existingUser.setDv(dv);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("El RUT tiene un formato incorrecto.");
                }
            } else {
                throw new IllegalArgumentException("El RUT debe tener el formato correcto: 12345678-9");
            }
        }

        return existingUser;
    }
}
