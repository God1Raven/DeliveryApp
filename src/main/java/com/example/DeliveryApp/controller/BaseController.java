package com.example.DeliveryApp.controller;

import com.example.DeliveryApp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController<T> {
    public BaseService<T> service;
    public BaseController(T t, BaseService<T> service){
        this.service = service;
    }


}
