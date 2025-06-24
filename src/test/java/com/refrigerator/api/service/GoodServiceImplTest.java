package com.refrigerator.api.service;

import com.refrigerator.api.model.Good;
import com.refrigerator.api.repository.GoodRepository;
import com.refrigerator.api.service.impl.GoodServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GoodServiceImplTest {

    @Mock
    private GoodRepository goodRepository;

    @InjectMocks
    private GoodServiceImpl goodService;

    public GoodServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllGoods() {

        Good good1 = new Good();
        good1.setName("Milk");
        Good good2 = new Good();
        good2.setName("Cheese");

        when(goodRepository.findAll()).thenReturn(List.of(good1, good2));


        List<Good> result = goodService.getAllGoods();


        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("Milk");

        verify(goodRepository, times(1)).findAll();
    }
}