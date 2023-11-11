package com.rhpm.testapp.modules.service;

import com.rhpm.testapp.modules.model.users.User;
import com.rhpm.testapp.modules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        User user = userRepository.findByEmail(email);
        if (user==null) {
            throw new UsernameNotFoundException(email);
        }else{
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(user.getPassword());
//            builder.roles(user.getRole());
        }
        return builder==null ? null : builder.build();
    }
}
