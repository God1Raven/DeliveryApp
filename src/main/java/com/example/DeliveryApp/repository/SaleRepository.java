package com.example.DeliveryApp.repository;

import com.example.DeliveryApp.entity.Admin;
import com.example.DeliveryApp.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
