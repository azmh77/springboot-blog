package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.posts.Category;
import com.rhpm.testapp.modules.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class CategoryController {
    private CategoryService categoryService;
    @Autowired()
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/get_category")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @RequestMapping(value = "/create_category")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
}
