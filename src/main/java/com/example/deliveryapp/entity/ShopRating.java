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
    @SequenceGenerator(
            name = "shop_rating_id_seq",
            schema = "public",
            sequenceName = "shop_rating_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name  = "id")
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "rating")
    private String rating;
}
