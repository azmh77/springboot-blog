package com.rhpm.testapp.modules.service;

import com.rhpm.testapp.modules.model.posts.Category;
import com.rhpm.testapp.modules.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category createCategory (Category category){
        return categoryRepository.save(category);
    }
}
