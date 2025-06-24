package com.refrigerator.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.refrigerator.api.model.Good;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long> {
	
	List<Good> findByCategoryId(Long categoryId);
}
