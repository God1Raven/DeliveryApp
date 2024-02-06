package com.example.deliveryapp.repository;

import com.example.deliveryapp.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
