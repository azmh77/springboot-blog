package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.posts.Category;
import com.rhpm.testapp.modules.model.users.User;
import com.rhpm.testapp.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @GetMapping(value = "/users/registerUsers")
    public String showRegisterCategory() {
        return "registerUsers";
    }

    @PostMapping(value = "/users/registerUsers")
    public String registerCategory(@ModelAttribute User user) throws IOException {
        userService.registerUser(user);
        return "redirect:/users";
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "get_users")
    public @ResponseBody List<User> getAllUser() {
        return userService.findAllUser();
    }

    @PostMapping(value = "create_users")
    public @ResponseBody User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
}
