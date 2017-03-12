package com.garrytrue.repository;

/**
 * Created by garrytrue on 12.03.17.
 */
public interface CRUDRepository<T> {

    void save(T data);

    T get(long id);

    void update(T data);

    T delete(T data);
}
