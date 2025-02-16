package com.previred.users_app.infrastructure.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequestDto {

    @Pattern(regexp = "^\\d{7,8}-[0-9kK]{1}$", message = "Formato de RUT inválido. Debe ser: 12345678-9")
    private String rut;

    @NotNull(message = "El nombre es obligatorio.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    private String nombres;

    @NotNull(message = "El apellido es obligatorio.")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres.")
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento es obligatoria.")
    @Past(message = "La fecha de nacimiento debe ser en el pasado.")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El correo electrónico es obligatorio.")
    @Email(message = "Debe ser un correo electrónico válido.")
    private String correoElectronico;

    @NotNull(message = "La contraseña es obligatoria.")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    private String contrasena;
}
