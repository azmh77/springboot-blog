package com.rhpm.testapp.modules.repository;

import com.rhpm.testapp.modules.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
