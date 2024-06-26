package com.example.deliveryapp.entity;

import com.example.deliveryapp.dto.StatusSale;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "sale")
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements EntityWithId<Long> {
    @Id
    @SequenceGenerator(name = "sale_sale_id_seq", schema = "public", sequenceName = "sale_sale_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_sale_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;
    @Column(name = "address")
    private String address;

    @jakarta.persistence.Enumerated(jakarta.persistence.EnumType.STRING)
    @Column(name = "status")
    private StatusSale status;

    public Sale(Long id, List<Product> products, StatusSale status, Client client, Shop shop, Courier courier) {
        this.id = id;
        this.products = products;
        this.shop = shop;
        this.courier = courier;
        this.client = client;
        this.status = status;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;
}
