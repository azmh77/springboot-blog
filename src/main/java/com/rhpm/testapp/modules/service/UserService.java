package com.rhpm.testapp.modules.service;

import com.rhpm.testapp.modules.model.User;
import com.rhpm.testapp.modules.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
