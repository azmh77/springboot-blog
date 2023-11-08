package com.rhpm.testapp.modules.repository;

import com.rhpm.testapp.modules.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
