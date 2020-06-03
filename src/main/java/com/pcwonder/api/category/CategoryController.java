package com.pcwonder.api.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CategoryController {

    private CategoryRepository repository;

    @Autowired
    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin("https://www.masonpohler.com")
    @GetMapping("/categories")
    List<Category> getCategories() {
        return repository.findAllByOrderByNameAsc();
    }
}
