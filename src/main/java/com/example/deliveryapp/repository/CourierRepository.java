package com.example.deliveryapp.repository;

import com.example.deliveryapp.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
