package com.previred.users_app.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequestDto {
    private Long rut;
    private String dv;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String correoElectronico;
    private String contrasena; 
}
