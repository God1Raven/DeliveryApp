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
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor

public class Shop {
    @Id
    @SequenceGenerator(name = "Shop_Shop_Id_seq", schema = "public", sequenceName = "Shop_Shop_Id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Shop_Shop_Id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Shop(Long id) {
        this.id = id;
    }
}
