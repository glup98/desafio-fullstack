package com.previred.users_app.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Base {

    private UUID id;                      
    private LocalDateTime creadoEn;       
    private LocalDateTime actualizadoEn;  

    public Base() {
    }

    public Base(UUID id, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(LocalDateTime actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }
}
