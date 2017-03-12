package com.garrytrue.repository.impl;

import com.garrytrue.repository.CRUDRepository;

public class ChainedRepository<T> implements CRUDRepository<T> {

    CRUDRepository<T> repository;
    CRUDRepository<T> nextLayerRepository;

    public ChainedRepository(CRUDRepository<T> repository) {
        this.repository = repository;
    }

    public void setNextLayerRepository(CRUDRepository<T> nextLayerRepository) {
        this.nextLayerRepository = nextLayerRepository;
    }

    /**
     * Save to all layers.
     */
    @Override
    public T save(T data) {
        repository.save(data);
        return nextLayerRepository.save(data);
    }

    /**
     * Get from this layer if not present then get from next leayer.
     */
    @Override
    public T get(long id) {
        T result = repository.get(id);
        if (result == null && nextLayerRepository != null) {
            result = nextLayerRepository.get(id);
        }
        return result;
    }

    @Override
    public T update(T data) {
        return null;
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
        if (nextLayerRepository != null) {
            nextLayerRepository.deleteAll();
        }
    }
}