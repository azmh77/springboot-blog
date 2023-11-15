package com.rhpm.testapp.modules.service;

import com.rhpm.testapp.modules.MyBeanCopy;
import com.rhpm.testapp.modules.enums.Role;
import com.rhpm.testapp.modules.model.users.User;
import com.rhpm.testapp.modules.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) throws IOException, InvocationTargetException, IllegalAccessException {
        if(!user.getFile().isEmpty()) {
            String path = ResourceUtils.getFile("classpath:static/img/").getAbsolutePath();
            byte[] bytea = user.getFile().getBytes();
            Files.write(Paths.get(path + File.separator + UUID.randomUUID() + user.getFile().getOriginalFilename()), bytea);
            user.setCover(UUID.randomUUID() + user.getFile().getOriginalFilename());
        }

        if(!user.getPassword().isEmpty()) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }else{
            user.setPassword(null);
        }

        if (user.getId() != null) {
            User exist = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found!"));
            MyBeanCopy myBeanCopy = new MyBeanCopy();
            myBeanCopy.copyProperties(exist,user);
            return userRepository.save(exist);
        }
        return userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        } else {
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(user.getPassword());
            builder.roles(user.getRoles().stream().map(Role::getAuthority).toList().toArray(new String[user.getRoles().size()]));
        }
        return builder == null ? null : builder.build();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
