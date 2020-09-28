package com.egorbarinov.lesson06.service;

import com.egorbarinov.lesson06.domain.Product;
import com.egorbarinov.lesson06.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

//    @Autowired
    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
//        init();
    }

//    private void init(){
//
//        productDAO.saveAll(Arrays.asList(
//                new Product(1L, "Cheese", 450.75),
//                new Product(2L, "Milk", 50.75),
//                new Product(3L, "Chocolate", 123.75),
//                new Product(4L, "Eggs", 75.0)
//        ));
//
//    }

    @Override
    public List<Product> getAll() {
        return productDAO.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

//    public List<Product> getByPrice(Double start, Double end){
//        return productRepo.getAll().stream()
//                .filter(product-> product.getPrice() >= start && product.getPrice() <= end)
//                .sorted(Comparator.comparingDouble(Product::getPrice))
//                .collect(Collectors.toList());
//    }

    @Override
    public List<Product> getByPrice(double priceFrom, double priceTo) {
        return productDAO.findAllByPriceBetween(priceFrom, priceTo);
    }

    @Override
    public void removeById(Long id){
        productDAO.deleteById(id);
    }



}
