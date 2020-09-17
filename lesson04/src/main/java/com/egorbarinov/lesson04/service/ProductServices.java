package com.egorbarinov.lesson04.service;

import com.egorbarinov.lesson04.domain.Product;
import com.egorbarinov.lesson04.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public void removeById(Long id){
        productRepo.deleteById(id);
    }

}
