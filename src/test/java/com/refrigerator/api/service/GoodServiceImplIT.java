package com.refrigerator.api.service;

import com.refrigerator.api.IntegrationTestBase;
import com.refrigerator.api.model.Good;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

@SpringBootTest
class GoodServiceImplIT extends IntegrationTestBase {

    @Autowired
    private GoodService goodService;

    @Test
    void testSaveAndGetGood() {
        Good good = new Good();
        good.setName("Milk");
        goodService.saveGood(good);

        List<Good> goods = goodService.getAllGoods();
        assertEquals(1, goods.size());
    }
}


