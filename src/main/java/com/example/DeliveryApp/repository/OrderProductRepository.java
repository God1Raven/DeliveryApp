package com.example.DeliveryApp.repository;

import com.example.DeliveryApp.entity.Admin;
import com.example.DeliveryApp.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
