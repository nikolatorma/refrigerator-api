package com.refrigerator.api.service.impl;

import com.refrigerator.api.model.Good;
import com.refrigerator.api.repository.GoodRepository;
import com.refrigerator.api.service.GoodService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    private final GoodRepository goodRepository;

    public GoodServiceImpl(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Override
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    @Override
    public Good getGoodById(Long id) {
        return goodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Good not found with id " + id));
    }

    @Override
    public Good saveGood(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public void deleteGood(Long id) {
        goodRepository.deleteById(id);
    }
    
    @Override
    public void deleteAllGoods() {
        goodRepository.deleteAll();
    }
    
    @Override
    public List<Good> getGoodsByCategoryId(Long categoryId) {
        return goodRepository.findByCategoryId(categoryId);
    }
}
