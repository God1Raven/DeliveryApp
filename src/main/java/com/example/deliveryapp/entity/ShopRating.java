package com.example.deliveryapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
    @SequenceGenerator(
            name = "shop_rating_shop_rating_id_seq",
            schema = "public",
            sequenceName = "shop_rating_shop_rating_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_rating_shop_rating_id_seq")
    @Column(name  = "id")
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "rating")
    private String rating;
}
