package com.previred.users_app.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private UUID id;
    private Long rut;
    private String dv;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
