package com.refrigerator.api.service.impl;

import com.refrigerator.api.model.FridgeItem;
import com.refrigerator.api.repository.FridgeItemRepository;
import com.refrigerator.api.service.FridgeItemService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FridgeItemServiceImpl implements FridgeItemService {

    private final FridgeItemRepository fridgeItemRepository;

    public FridgeItemServiceImpl(FridgeItemRepository fridgeItemRepository) {
        this.fridgeItemRepository = fridgeItemRepository;
    }

    @Override
    public List<FridgeItem> getAllFridgeItems() {
        return fridgeItemRepository.findAll();
    }

    @Override
    public FridgeItem getFridgeItemById(Long id) {
        return fridgeItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FridgeItem not found with id " + id));
    }

    @Override
    public FridgeItem saveFridgeItem(FridgeItem good) {
        return fridgeItemRepository.save(good);
    }

    @Override
    public void deleteFridgeItem(Long id) {
    	fridgeItemRepository.deleteById(id);
    }
    
    @Override
    public void deleteAllFridgeItems() {
    	fridgeItemRepository.deleteAll();
    }
    
    @Override
    public List<FridgeItem> getFridgeItemsByUserId(Long userId) {
        return fridgeItemRepository.findByUserId(userId);
    }
}
