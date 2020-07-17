package com.example.o2o.service.impl;

import com.example.o2o.domain.TbShop;
import com.example.o2o.dto.ShopExecution;
import com.example.o2o.enums.ShopStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TbShopServiceImplTest {
    @Autowired
    private TbShopServiceImpl shopService;

    @Test
    void addShop() {
        TbShop shop = new TbShop();
        shop.setOwnerId(1);
        shop.setAreaId(2);
        shop.setShopCategoryId(10);
        shop.setShopName("商店名称");
        shop.setShopDesc("商店描述");
        shop.setShopAddr("商店地址");
        shop.setPhone("商店电话");
        shop.setPriority(0);
        shop.setAdvice("商店建议");
        shop.setShopImg("/upload");
        ShopExecution shopExecution = shopService.addShop(shop);
        assertEquals(ShopStateEnum.CHECK.getState(), shopExecution.getState());
    }
}