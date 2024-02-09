package com.example.deliveryapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @SequenceGenerator(
            name = "client_id_seq",
            schema = "public",
            sequenceName = "client_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
}
