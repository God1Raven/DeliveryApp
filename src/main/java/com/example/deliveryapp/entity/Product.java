package com.example.deliveryapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "parametrs")
    private String parameter;

    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Sale> sales;


    @Getter
    @AllArgsConstructor
    public static class Parameter {

    }
}
