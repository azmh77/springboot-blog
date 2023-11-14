package com.rhpm.testapp.modules.repository;

import com.rhpm.testapp.modules.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    @Override
    Optional<User> findById(Long id);
}
