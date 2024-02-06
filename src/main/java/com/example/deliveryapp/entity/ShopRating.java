package com.example.deliveryapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "shop_rating")
@NoArgsConstructor
@AllArgsConstructor

public class ShopRating {
    @Id
    @GeneratedValue
    @Column(name  = "id")
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "rating")
    private String rating;
}
