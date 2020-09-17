package com.egorbarinov.lesson04.repository;

import com.egorbarinov.lesson04.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
//    Product findByPrice();

}
