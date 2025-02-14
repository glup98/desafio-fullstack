package com.ejemplo.desafio.domain.model;

import java.util.Date;

public class User {

    private Long rut;
    private String dv;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String correoElectronico;
    private String contrasena;

    public User() {
    }

    public User(Long rut, String dv, String nombres, String apellidos,
                Date fechaNacimiento, String correoElectronico, String contrasena) {
        this.rut = rut;
        this.dv = dv;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public Long getRut() {
        return rut;
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
