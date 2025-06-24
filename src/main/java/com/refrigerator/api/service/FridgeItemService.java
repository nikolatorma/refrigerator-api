package com.refrigerator.api.service;

import com.refrigerator.api.model.FridgeItem;
import java.util.List;

public interface FridgeItemService {
    
	List<FridgeItem> getAllFridgeItems();
    
	FridgeItem getFridgeItemById(Long id);
    
	FridgeItem saveFridgeItem(FridgeItem fridgeItem);
    
	void deleteFridgeItem(Long id);
	
	void deleteAllFridgeItems();
	
	List<FridgeItem> getFridgeItemsByUserId(Long userId);
}
