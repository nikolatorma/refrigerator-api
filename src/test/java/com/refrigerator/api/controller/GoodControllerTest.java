package com.refrigerator.api.controller;

import com.refrigerator.api.dto.GoodDto;
import com.refrigerator.api.service.GoodService;
import com.refrigerator.api.mapper.GoodMapper;
import com.refrigerator.api.model.Good;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GoodControllerTest {

    @Mock
    private GoodService goodService;

    @Mock
    private GoodMapper goodMapper;

    @InjectMocks
    private GoodController goodController;

    @Test
    void testGetAllGoods() {
        Good good = new Good();
        good.setId(1L);
        good.setName("Milk");

        GoodDto goodDto = new GoodDto();
        goodDto.setId(1L);
        goodDto.setName("Milk");

        when(goodService.getAllGoods()).thenReturn(List.of(good));
        when(goodMapper.toDto(good)).thenReturn(goodDto);

        ResponseEntity<List<GoodDto>> response = goodController.getAllGoods();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals("Milk", response.getBody().get(0).getName());
    }
}

