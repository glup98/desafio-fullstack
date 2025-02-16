package com.previred.users_app.app.service;

import java.util.List;
import java.util.Optional;

import com.previred.users_app.domain.repository.BaseRepositoryPort;

public abstract class BaseCrudService<T, ID> {

    protected final BaseRepositoryPort<T, ID> repositoryPort;

    public BaseCrudService(BaseRepositoryPort<T, ID> repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public T create(T entity) {
        return repositoryPort.create(entity);
    }

    public List<T> findAll() {
        return repositoryPort.findAll();
    }

    public Optional<T> findById(ID id) {
        return repositoryPort.findById(id);
    }

    public T update(T entity) {
        return repositoryPort.update(entity);
    }

    public void deleteById(ID id) {
        repositoryPort.deleteById(id);
    }
}
