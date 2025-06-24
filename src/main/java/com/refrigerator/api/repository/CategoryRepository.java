package com.refrigerator.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.refrigerator.api.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
