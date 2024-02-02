package com.example.DeliveryApp.repository;

import com.example.DeliveryApp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
