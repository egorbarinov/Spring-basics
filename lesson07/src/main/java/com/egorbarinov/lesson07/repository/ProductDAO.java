package com.egorbarinov.lesson07.repository;

import com.egorbarinov.lesson07.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceBetween(Double startPrice, Double endPrice);
}
