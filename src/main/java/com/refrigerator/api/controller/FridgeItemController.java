package com.refrigerator.api.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.refrigerator.api.dto.FridgeItemDto;
import com.refrigerator.api.mapper.FridgeItemMapper;
import com.refrigerator.api.model.FridgeItem;
import com.refrigerator.api.service.FridgeItemService;

import java.util.List;

@RestController
@RequestMapping("/api/fridge-items")
public class FridgeItemController {

	private final FridgeItemService fridgeItemService;
    private final FridgeItemMapper mapper;

    public FridgeItemController(FridgeItemService fridgeItemService, FridgeItemMapper mapper) {
        this.fridgeItemService = fridgeItemService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<FridgeItemDto>> getAllFridgeItems() {
        List<FridgeItemDto> fridgeItems = fridgeItemService.getAllFridgeItems()
                                         .stream()
                                         .map(mapper::toDto)
                                         .toList();
        return ResponseEntity.ok(fridgeItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FridgeItemDto> getFridgeItemById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(fridgeItemService.getFridgeItemById(id)));
    }

    @PostMapping
    public ResponseEntity<FridgeItemDto> createFridgeItem(@RequestBody FridgeItemDto fridgeItemDto) {
        FridgeItem saved = fridgeItemService.saveFridgeItem(mapper.toEntity(fridgeItemDto));
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FridgeItemDto> updateFridgeItem(@PathVariable Long id, @RequestBody FridgeItemDto fridgeItemDto) {
    	
    	FridgeItem existingFridgeItem = fridgeItemService.getFridgeItemById(id);
        existingFridgeItem.setLocation(fridgeItemDto.getLocation());
        existingFridgeItem.setQuantity(fridgeItemDto.getQuantity());
        existingFridgeItem.setDateStored(fridgeItemDto.getDateStored());
        existingFridgeItem.setBestBeforeDate(fridgeItemDto.getBestBeforeDate());
        existingFridgeItem.setGoodId(fridgeItemDto.getGoodId());
        existingFridgeItem.setUserId(fridgeItemDto.getUserId());
        FridgeItem updated = fridgeItemService.saveFridgeItem(existingFridgeItem);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFridgeItem(@PathVariable Long id) {
    	fridgeItemService.deleteFridgeItem(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearFridgeItems() {
        fridgeItemService.deleteAllFridgeItems();
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/by-user/{userId}")
    public List<FridgeItem> getFridgeItemsByUser(@PathVariable Long userId) {
        return fridgeItemService.getFridgeItemsByUserId(userId);
    }
}
