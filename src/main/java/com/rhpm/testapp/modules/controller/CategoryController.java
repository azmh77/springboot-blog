package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.posts.Category;
import com.rhpm.testapp.modules.model.posts.Post;
import com.rhpm.testapp.modules.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    @Autowired()
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping(value = "/category/registerCategory")
    public String showRegisterCategory() {
        return "registerCategory";
    }

    @PostMapping(value = "/category/registerCategory")
    public String registerCategory(@ModelAttribute Category category) throws IOException {
        categoryService.createCategory(category);
        return "redirect:/category";
    }

    @RequestMapping(value = "/get_category")
    public @ResponseBody List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @RequestMapping(value = "/create_category")
    public @ResponseBody Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
}
