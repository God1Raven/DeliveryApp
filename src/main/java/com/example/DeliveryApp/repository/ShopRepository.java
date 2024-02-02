package com.example.DeliveryApp.repository;

import com.example.DeliveryApp.entity.Admin;
import com.example.DeliveryApp.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
