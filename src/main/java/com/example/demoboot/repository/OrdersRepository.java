package com.example.demoboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoboot.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
