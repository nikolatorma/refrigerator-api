package com.refrigerator.api.service;

import com.refrigerator.api.model.Good;
import java.util.List;

public interface GoodService {
    
	List<Good> getAllGoods();
    
	Good getGoodById(Long id);
    
	Good saveGood(Good good);
    
	void deleteGood(Long id);
	
	void deleteAllGoods();
	
	List<Good> getGoodsByCategoryId(Long categoryId);
}
