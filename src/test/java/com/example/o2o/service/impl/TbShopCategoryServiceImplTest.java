package com.example.o2o.service.impl;

import com.example.o2o.domain.TbShopCategory;
import com.example.o2o.mapper.TbShopCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TbShopCategoryServiceImplTest {
    @Autowired
    private TbShopCategoryMapper tbShopCategoryMapper;

    @Test
    void findByParentIdOrderByPriorityDesc() { List<TbShopCategory> byParentIdOrderByPriorityDesc = tbShopCategoryMapper.findByParentIdOrderByPriorityDesc(10);
        log.info("byParentIdOrderByPriorityDesc:{}", byParentIdOrderByPriorityDesc);
        Assert.assertNotEquals(0, byParentIdOrderByPriorityDesc.size());
    }
}