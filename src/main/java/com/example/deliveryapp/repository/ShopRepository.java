package com.example.deliveryapp.repository;

import com.example.deliveryapp.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
