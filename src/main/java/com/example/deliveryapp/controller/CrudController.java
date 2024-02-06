package com.example.deliveryapp.controller;

import com.example.deliveryapp.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public abstract class CrudController<T> {
    public BaseService<T> baseService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<T> create(@RequestBody T t) {
        T type = baseService.create(t);
        return ResponseEntity.ok(type);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public T update(T t) {
        return baseService.update(t);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public T get(@PathVariable("id") Long id) {
        return baseService.get(id);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Long id) {
        baseService.delete(id);
    }
}
