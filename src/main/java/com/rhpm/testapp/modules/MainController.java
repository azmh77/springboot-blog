package com.rhpm.testapp.modules;

import com.rhpm.testapp.modules.model.users.User;
import com.rhpm.testapp.modules.service.CategoryService;
import com.rhpm.testapp.modules.service.PostService;
import com.rhpm.testapp.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private PostService postService;

    private UserService userService;

    private CategoryService categoryService;

    @Autowired()
    public MainController(PostService postService, UserService userService, CategoryService categoryService) {
        this.postService = postService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("posts" , postService.getAllPost());
        return "index";
    }

    @RequestMapping("/Login")
    public String login() {
        return "Login";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users" , userService.findAllUser());
        return "users";
    }

    @RequestMapping("/category")
    public String category( Model model) {
        model.addAttribute("category" , categoryService.getAllCategory());
        return "category";
    }
}
