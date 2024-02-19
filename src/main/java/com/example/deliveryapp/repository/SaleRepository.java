package com.example.deliveryapp.repository;

import com.example.deliveryapp.dto.StatusSale;
import com.example.deliveryapp.entity.Product;
import com.example.deliveryapp.entity.Sale;
import com.example.deliveryapp.entity.ShopRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByStatus(StatusSale status);


}
