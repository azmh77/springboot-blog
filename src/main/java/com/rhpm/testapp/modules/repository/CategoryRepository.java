package com.rhpm.testapp.modules.repository;

import com.rhpm.testapp.modules.model.posts.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository()
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findById(Long id);
}
