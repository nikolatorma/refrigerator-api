package com.refrigerator.api.controller;

import com.refrigerator.api.model.Category;
import com.refrigerator.api.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
