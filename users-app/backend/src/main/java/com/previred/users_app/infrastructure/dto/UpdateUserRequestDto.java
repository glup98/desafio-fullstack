package com.previred.users_app.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequestDto {

    @Pattern(regexp = "^\\d{7,8}-[0-9kK]{1}$", message = "Formato de RUT inválido. Debe ser: 12345678-9")
    private String rut;

    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombres;

    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    private String apellidos;

    private LocalDate fechaNacimiento;

    @Email(message = "Correo electrónico no válido")
    private String correoElectronico;

    @NotNull(message = "La contraseña es obligatoria.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    private String contrasena;

}
