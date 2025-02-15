package com.previred.users_app.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Base {

    private UUID id;                      
    private LocalDateTime creadoEn;       
    private LocalDateTime actualizadoEn;  

    public Base(UUID id, LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
        this.id = id;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
    }
}
