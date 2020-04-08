package com.pcwonder.api.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> getProducts() {
        return repository.findAll();
    }
}
