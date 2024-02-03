package com.example.DeliveryApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

}
