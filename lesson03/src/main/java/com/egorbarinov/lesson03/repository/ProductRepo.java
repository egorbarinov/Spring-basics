package com.egorbarinov.lesson03.repository;

import com.egorbarinov.lesson03.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
    Product findByPrice();

}
