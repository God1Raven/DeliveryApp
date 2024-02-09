package com.example.deliveryapp.entity;

import com.example.deliveryapp.dto.StatusSale;
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
public class Sale implements EntityWithId<Long> {
    @Id
    @SequenceGenerator(
            name = "sale_id_seq",
            schema = "public",
            sequenceName = "sale_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private StatusSale status;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "courier_id", nullable = false)
    private Courier courier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;
}

//TODO прикрутить таблицу с рейтингом магазина, пересмотрев связи  многие ко многим в бд

