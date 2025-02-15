package com.previred.users_app.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User extends Base {

    private Long rut;
    private String dv;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    private Password contrasena;


    public User(Long rut, String dv, String nombres, String apellidos,
                LocalDate fechaNacimiento, String correoElectronico, Password contrasena) {
        this.rut = rut;
        this.dv = dv;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public User(UUID id, LocalDateTime creadoEn, LocalDateTime actualizadoEn,
                Long rut, String dv, String nombres, String apellidos,
                LocalDate fechaNacimiento, String correoElectronico, Password contrasena) {
        super(id, creadoEn, actualizadoEn);
        this.rut = rut;
        this.dv = dv;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }
}
