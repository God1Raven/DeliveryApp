package com.example.deliveryapp.controller;

import com.example.deliveryapp.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public abstract class CrudController<T, S extends BaseService<T>> {
    public S baseService;

    @RequestMapping(method = RequestMethod.POST)
    @RouterOperation(operation = @Operation(description = "Create entity"))
    public ResponseEntity<T> create(@RequestBody T t) {
        T type = baseService.create(t);
        return ResponseEntity.ok(type);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public T update(@RequestBody T t) {
        return baseService.update(t);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<T> get(@PathVariable("id") Long id) {
        T getRequest = baseService.get(id);
        if (getRequest != null) {
            return ResponseEntity.ok(getRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        baseService.delete(id);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<T> getAll() {
        return baseService.getAll();
    }
}
