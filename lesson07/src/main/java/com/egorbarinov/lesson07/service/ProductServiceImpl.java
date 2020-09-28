package com.egorbarinov.lesson07.service;

import com.egorbarinov.lesson07.domain.Product;
import com.egorbarinov.lesson07.repository.ProductDAO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
//        init();
    }

//    private void init(){
//
//        productDAO.saveAll(Arrays.asList(
//                new Product(null, "Cheese", 450.75),
//                new Product(null, "Milk", 50.75),
//                new Product(null, "Chocolate", 123.75),
//                new Product(null, "Eggs", 75.0)
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
