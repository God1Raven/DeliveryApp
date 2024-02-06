package com.example.deliveryapp.repository;
import com.example.deliveryapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {
}
