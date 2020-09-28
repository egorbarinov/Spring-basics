package com.egorbarinov.lesson06.service;



import com.egorbarinov.lesson06.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);

    Product save(Product product);

    List<Product> getByPrice(double priceFrom, double priceTo);

    void removeById(Long id);
}
