package com.egorbarinov.lesson04.controller;

import com.egorbarinov.lesson04.domain.Product;
import com.egorbarinov.lesson04.repository.ProductRepo;
import com.egorbarinov.lesson04.service.ProductServiceImpl;
import com.egorbarinov.lesson04.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {

//    private final ProductServiceImpl productService;


    private ProductServices productServices;

    @Autowired
    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    // http://localhost:8080/app/products - GET
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        Iterable<Product> products = productServices.getAllProducts();
        model.addAttribute("products", products);
        return "list";
    }

//    // http://localhost:8080/app/products/1 - GET
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public String getById(Model model,@PathVariable("id") Long id){
//        Product byId = productService.getById(id);
//        model.addAttribute("product",
//                byId == null ? new Product(): byId);
//        return "product";
//    }

//    // http://localhost:8080/app/products/1/price - GET
//    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
//    @ResponseBody
//    public String apiPrice(@PathVariable Long id){
//        Product byId = productService.getById(id);
//        return String.valueOf(byId == null ? null : byId.getPrice());
//    }

    // http://localhost:8080/app/products/new - GET
    @GetMapping("/new")
    public String getFormNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "new-product";
    }

    // http://localhost:8080/app/products/new - POST
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        Product savedProduct = productServices.saveProduct(product);
        System.out.println(savedProduct);
        return "redirect:/products/" + savedProduct.getId();
    }

    // http://localhost:8080/app/products/any
    @RequestMapping(value = "any")
    @ResponseBody
    public String anyRequest(){
        return "any request " + UUID.randomUUID().toString();
    }

//    // http://localhost:8080/app/products?price_from=35.4&priceTo=3
//    @GetMapping(params = {"price_from", "priceTo"})
//    public String productsByPrice(Model model,
//                                  @RequestParam(name = "price_from") double priceFrom,
//                                  @RequestParam double priceTo){
//        List<Product> products = productService.getByPrice(priceFrom, priceTo);
//        model.addAttribute("products", products);
//        return "list";
//    }

//    // http://localhost:8080/app/filter?price_from=35.4&priceTo=3
//    @GetMapping("/filter")
//    public String filterByPrice(Model model,
//                                  @RequestParam(name = "price_from") double priceFrom,
//                                  @RequestParam(required = false) Double priceTo){
//        List<Product> products =
//                productService.getByPrice(priceFrom, priceTo == null ? Double.MAX_VALUE : priceTo);
//        model.addAttribute("products", products);
//        return "list";
//    }

//    // http://localhost:8080/app/filter {title:"asd"}
//    @PostMapping("/filter")
//    @ResponseBody
//    public String filterByTitle(@RequestParam String title){
//        return productService.getAll().stream()
//                .filter(product-> product.getTitle().contains(title))
//                .map(product -> String.valueOf(product.getId()))
//                .collect(Collectors.joining(","));
//    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        productServices.removeById(id);
        productServices.getAllProducts();
        return "redirect:/products";
    }

}
