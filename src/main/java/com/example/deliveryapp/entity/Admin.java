package com.example.deliveryapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @SequenceGenerator(
        name = "admin_id_seq",
        schema = "public",
        sequenceName = "admin_id_seq",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_id_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
}
