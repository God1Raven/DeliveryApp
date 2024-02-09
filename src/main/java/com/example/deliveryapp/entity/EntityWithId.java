package com.example.deliveryapp.entity;

public interface EntityWithId<T> {

    T getId();

    void setId(T id);

}
