package com.egorbarinov.lesson07.service;

import com.egorbarinov.lesson07.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);

    Product save(Product product);

    List<Product> getByPrice(double priceFrom, double priceTo);

    void removeById(Long id);

}
