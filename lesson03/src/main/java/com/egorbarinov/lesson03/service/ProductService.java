package com.egorbarinov.lesson03.service;

import com.egorbarinov.lesson03.domain.Product;
import com.egorbarinov.lesson03.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;

//    @Autowired
//    public void setProductRepo(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }


    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }


    public Product getProductByPrice(double priceFrom, double Price) {
        return productRepo.findByPrice();
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }


}
