package com.rhpm.testapp.modules.repository;

import com.rhpm.testapp.modules.model.posts.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
