package com.java.springboot.getting_started.rest_api.models.interfaces;

import java.util.UUID;

public interface IBaseRepository<T> {
    public T[] findAll();

    public T findByUUID(UUID id);

    public T findByName(String productName);

    public T add(T t);

    public T updateByUUID(UUID id, T t);

    public T deleteByUUID(UUID id);
}
