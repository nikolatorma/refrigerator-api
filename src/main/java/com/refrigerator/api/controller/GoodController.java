package com.refrigerator.api.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.refrigerator.api.dto.GoodDto;
import com.refrigerator.api.mapper.GoodMapper;
import com.refrigerator.api.model.Good;
import com.refrigerator.api.service.GoodService;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodController {

	private final GoodService goodService;
    private final GoodMapper mapper;

    public GoodController(GoodService goodService, GoodMapper mapper) {
        this.goodService = goodService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<GoodDto>> getAllGoods() {
        List<GoodDto> goods = goodService.getAllGoods()
                                         .stream()
                                         .map(mapper::toDto)
                                         .toList();
        return ResponseEntity.ok(goods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodDto> getGoodById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(goodService.getGoodById(id)));
    }

    @PostMapping
    public ResponseEntity<GoodDto> createGood(@RequestBody GoodDto goodDto) {
        Good saved = goodService.saveGood(mapper.toEntity(goodDto));
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGood(@PathVariable Long id) {
        goodService.deleteGood(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearGoods() {
        goodService.deleteAllGoods();
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/by-category/{categoryId}")
    public List<Good> getGoodsByCategory(@PathVariable Long categoryId) {
        return goodService.getGoodsByCategoryId(categoryId);
    }
}
