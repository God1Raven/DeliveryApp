package com.example.deliveryapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    public Long getId() {
        return id;
    }

    public Client(Long id) {
        this.id = id;
    }

    @Id
    @SequenceGenerator(name = "client_client_id_seq", schema = "public", sequenceName = "client_client_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_client_id_seq")
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
