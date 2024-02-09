package com.example.deliveryapp.service;

import org.springframework.transaction.annotation.Transactional;

public interface BaseService<T> {
    public T create(T t);
    public T update(T t);
    public T get (Long id);
    public void delete(Long id);
}
