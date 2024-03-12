package com.example.deliveryapp.repository;

import com.example.deliveryapp.entity.Admin;
import com.example.deliveryapp.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
