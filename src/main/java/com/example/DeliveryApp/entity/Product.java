package com.example.DeliveryApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import io.hypersistence.utils.hibernate.type.json.JsonType;

import java.util.List;
import org.hibernate.annotations.Type;

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
    @Type(JsonType.class)
    private Parameter parameter;

    @ManyToMany
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Sale> sales;


    @Getter
    @AllArgsConstructor
    public static class Parameter {

    }
}
