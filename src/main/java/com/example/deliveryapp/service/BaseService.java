package com.example.deliveryapp.service;

import java.util.List;

public interface BaseService<T> {
    public T create(T t);

    public T update(T t);

    public T get(Long id);

    public void delete(Long id);

    public List<T> getAll();
}
