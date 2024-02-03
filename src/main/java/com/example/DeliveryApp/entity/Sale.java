package com.example.DeliveryApp.entity;

import com.example.DeliveryApp.dto.StatusSale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "sale")
@NoArgsConstructor
@AllArgsConstructor


public class Sale {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;
    @Column(name = "adress")
    private String address;
    @Column (name = "shop_id")
    private Long shopId;
    @Column (name = "user_id")
    private Long userId;
    @Column (name = "courier_id")
    private Long courierId;
    @Column(name = "status")
    private StatusSale status;

    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
