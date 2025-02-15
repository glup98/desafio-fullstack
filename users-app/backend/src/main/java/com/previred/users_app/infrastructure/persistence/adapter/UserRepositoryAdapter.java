package com.previred.users_app.infrastructure.persistence.adapter;

import com.previred.users_app.domain.model.Password;
import com.previred.users_app.domain.model.User;
import com.previred.users_app.domain.repository.UserRepositoryPort;
import com.previred.users_app.infrastructure.persistence.entity.UserEntity;
import com.previred.users_app.infrastructure.persistence.repository.UserRepositorySpringData;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepositoryAdapter extends BaseRepositoryAdapter<User, UUID, UserEntity> implements UserRepositoryPort {

    public UserRepositoryAdapter(UserRepositorySpringData userRepositorySpringData) {
        super(userRepositorySpringData);
    }

    @Override
    protected UserEntity toEntity(User domain) {
        UserEntity entity = new UserEntity();
        entity.setId(domain.getId());
        entity.setRut(domain.getRut());
        entity.setDv(domain.getDv());
        entity.setNombres(domain.getNombres());
        entity.setApellidos(domain.getApellidos());
        entity.setFechaNacimiento(domain.getFechaNacimiento());
        entity.setCorreoElectronico(domain.getCorreoElectronico());

        if (domain.getContrasena() != null) {
            entity.setContrasena(domain.getContrasena().getHashedValue());
        }

        entity.setCreadoEn(domain.getCreadoEn());
        entity.setActualizadoEn(domain.getActualizadoEn());

        return entity;
    }

    @Override
    protected User toDomain(UserEntity entity) {
        User domain = new User(
                entity.getId(),
                entity.getCreadoEn(),
                entity.getActualizadoEn(),
                entity.getRut(),
                entity.getDv(),
                entity.getNombres(),
                entity.getApellidos(),
                entity.getFechaNacimiento(),
                entity.getCorreoElectronico(),
                entity.getContrasena() != null
                        ? Password.ofHash(entity.getContrasena())
                        : null);
        return domain;
    }

}
