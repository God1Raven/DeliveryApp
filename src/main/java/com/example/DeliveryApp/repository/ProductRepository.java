package com.example.DeliveryApp.repository;

import com.example.DeliveryApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
