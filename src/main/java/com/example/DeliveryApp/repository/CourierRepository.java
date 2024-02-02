package com.example.DeliveryApp.repository;

import com.example.DeliveryApp.entity.Admin;
import com.example.DeliveryApp.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
