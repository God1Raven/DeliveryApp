package com.example.DeliveryApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "order_product")
@NoArgsConstructor
@AllArgsConstructor

public class OrderProduct {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

//    @Column(name = "order_id")
//    private Long sale_id;

    // ???
//    @OneToOne(targetEntity = Sale.class, mappedBy = "sale_id")
//    private Sale sale;

    @Column(name = "product_id")
    private Long product_id;
}
