package com.previred.users_app.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.previred.users_app.domain.repository.BaseRepositoryPort;

public abstract class BaseRepositoryAdapter<T, ID, E> implements BaseRepositoryPort<T, ID> {

    protected final JpaRepository<E, ID> jpaRepository;

    protected BaseRepositoryAdapter(JpaRepository<E, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T create(T entity) {
        E saved = jpaRepository.save(toEntity(entity));
        return toDomain(saved);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public T update(T entity) {
        E updated = jpaRepository.save(toEntity(entity));
        return toDomain(updated);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    protected abstract E toEntity(T domain);
    protected abstract T toDomain(E entity);
}
