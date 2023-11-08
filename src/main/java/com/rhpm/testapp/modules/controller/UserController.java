package com.rhpm.testapp.modules.controller;

import com.rhpm.testapp.modules.model.users.User;
import com.rhpm.testapp.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/",""})
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @PostMapping(value = {"/",""})
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
}
