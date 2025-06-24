package com.refrigerator.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.refrigerator.api.model.FridgeItem;

@Repository
public interface FridgeItemRepository extends JpaRepository<FridgeItem, Long> {
	
	List<FridgeItem> findByUserId(Long userId);
}
