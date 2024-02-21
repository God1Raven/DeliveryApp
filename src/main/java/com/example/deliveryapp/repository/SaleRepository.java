package com.example.deliveryapp.repository;

import com.example.deliveryapp.dto.StatusSale;
import com.example.deliveryapp.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByStatus(StatusSale status);


}
