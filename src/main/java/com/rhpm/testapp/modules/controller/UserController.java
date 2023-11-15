package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.posts.Category;
import com.rhpm.testapp.modules.model.users.User;
import com.rhpm.testapp.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users" , userService.findAllUser());
        return "users";
    }

    @GetMapping(value = "/users/registerUsers")
    public String showRegisterUser(Model model) {
        model.addAttribute("user" , new User());
        return "registerUsers";
    }

    @GetMapping(value = "/users/edite/{id}")
    public String EditeUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user" , userService.findById(id));
        return "registerUsers";
    }

    @GetMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @PostMapping(value = "/users/registerUsers")
    public String registerUsers(@ModelAttribute User user) throws IOException, InvocationTargetException, IllegalAccessException {
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
    public @ResponseBody User registerUser(@RequestBody User user) throws IOException, InvocationTargetException, IllegalAccessException {
        return userService.registerUser(user);
    }
}
