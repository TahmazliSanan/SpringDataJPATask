package com.springdatajpatutorial.springboot.repository;

import com.springdatajpatutorial.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCreatedDateBetween(LocalDateTime beginDate, LocalDateTime endDate);
}