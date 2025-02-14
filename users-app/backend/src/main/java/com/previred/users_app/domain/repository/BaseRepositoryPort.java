package com.previred.users_app.domain.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepositoryPort<T, ID> {

    T create(T entity);

    List<T> findAll();

    Optional<T> findById(ID id);

    T update(T entity);

    void deleteById(ID id);
}
