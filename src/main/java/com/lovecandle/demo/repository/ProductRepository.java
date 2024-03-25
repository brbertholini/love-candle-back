package com.lovecandle.demo.repository;

import com.lovecandle.demo.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
